package ObserverDesignPattern;

public class TopicSubscriber implements Observer {
    public String name;
    public Subject topic;

    TopicSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        String message = (String)topic.getUpdate(this);
        if(message == null) {
            System.out.println("No message updated");
        } else {
            System.out.println("message updated.........");
        }
    }

    @Override
    public void setSubject(Subject subject) {
        this.topic = subject;
    }
}
