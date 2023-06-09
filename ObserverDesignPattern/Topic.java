package ObserverDesignPattern;
import java.util.List;
import java.util.ArrayList;

public class Topic implements Subject {

    List<Observer> observers;
    public Object MUTEX = new Object();
    public String message;
    public boolean state;

    public Topic() {
        observers = new ArrayList<Observer>();
    }

    @Override
    public void register(Observer observer) {
        // TODO Auto-generated method stub
        if(observer == null) {
            throw new NullPointerException("Null observer");
        }
        synchronized(MUTEX) {
            if(!observers.contains(observer)) {
                observers.add(observer);
            }
        }
    }

    @Override
    public void deregister(Observer observer) {
        synchronized(MUTEX) {
            if(observers.contains(observer)) {
                observers.remove(observer);
            }
        }
    }

    @Override
    public void notifyAllObservers() {
        List<Observer> observersLocal = null;
        synchronized(MUTEX) {
            if(!state) return;
            observersLocal = new ArrayList<>(observers);
            state = false;
        }

        for(Observer obs : observersLocal) {
            obs.update();
        }
    }

    @Override
    public String getUpdate(Observer observer) {
        return this.message;
    }
    
    public void postMessage(String msg){
		System.out.println("Message Posted to Topic:"+msg);
		this.message=msg;
		this.state=true;
		notifyAllObservers();
	}

}
