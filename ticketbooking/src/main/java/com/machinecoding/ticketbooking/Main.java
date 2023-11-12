package com.machinecoding.ticketbooking;

import com.machinecoding.ticketbooking.controller.*;
import com.machinecoding.ticketbooking.model.Screen;
import com.machinecoding.ticketbooking.model.Seat;
import com.machinecoding.ticketbooking.model.Theatre;
import com.machinecoding.ticketbooking.repository.*;
import com.machinecoding.ticketbooking.service.*;
import com.machinecoding.ticketbooking.utils.InMemoryLockingService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        TheatreRepository theatreRepository = new TheatreRepository();
        TheatreService theatreService = new TheatreService(theatreRepository);
        TheatreController theatreController = new TheatreController(theatreService);

        ScreenRepository screenRepository = new ScreenRepository();
        ScreenService screenService = new ScreenService(screenRepository);
        ScreenController screenController = new ScreenController(screenService);

        MovieRepository movieRepository = new MovieRepository();
        MovieService movieService = new MovieService(movieRepository);
        MovieController movieController = new MovieController(movieService);

        ShowRepository showRepository = new ShowRepository();
        ShowService showService = new ShowService(showRepository, movieService, screenService);
        ShowController showController = new ShowController(showService);


        UserController userController = new UserController(new UserService(new UserRepository()));
        userController.addUser("aakash@gmail.com", "Akkiii");
        userController.addUser("abc@gmail.com", "ABC");

        SeatController seatController = new SeatController(new SeatService(new SeatRepository()));
        String s1 = seatController.addSeat('A', 11);
        String s2 = seatController.addSeat('A', 12);
        String s3 = seatController.addSeat('A', 13);
        String s4 = seatController.addSeat('A', 14);
        String s5 = seatController.addSeat('A', 15);

        String theatre = theatreController.createTheatre("PVR");

        String screenId = screenController.createScreen("Audi01", theatreController.getTheatreById(theatre));
        Screen screen = screenController.getScreenById(screenId);
        screen.addSeat(seatController.getSeatById(s1));
        screen.addSeat(seatController.getSeatById(s2));
        screen.addSeat(seatController.getSeatById(s3));
        screen.addSeat(seatController.getSeatById(s4));
        screen.addSeat(seatController.getSeatById(s5));

        String movieId = movieController.createMovie("Fukrey3");

        String showId = showController.createShow("fukrey", movieId, screenId, new Date(), 2);

        InMemoryLockingService inMemoryLockingService = new InMemoryLockingService(showService);
        //Use Case 1
        List<Seat> availableSeatsForU1 = inMemoryLockingService.getAvailableSeats(showController.getShowById(showId));
        System.out.println(availableSeatsForU1);
        List<Seat> selectedSeats = new ArrayList<>();

        for(int i = 0; i < availableSeatsForU1.size() - 2; i++) {
            selectedSeats.add(availableSeatsForU1.get(i));
        }

        PaymentController paymentController = new PaymentController(new PaymentService(inMemoryLockingService));

        paymentController.payForSelectedSeats(showController.getShowById(showId), selectedSeats, userController.getUserById("aakash@gmail.com"));

        List<Seat> availableSeatsForU2 = inMemoryLockingService.getAvailableSeats(showController.getShowById(showId));
        System.out.println(availableSeatsForU2);

//        paymentController.paymentSuccessful();

    }
}
