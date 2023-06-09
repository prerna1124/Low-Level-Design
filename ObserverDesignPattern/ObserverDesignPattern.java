package ObserverDesignPattern;

public class ObserverDesignPattern {
    public static void main(String[] args) {
        
        Topic topic = new Topic();

        Observer observer1 = new TopicSubscriber("observer1");
        Observer observer2 = new TopicSubscriber("observer2");
        Observer observer3 = new TopicSubscriber("observer3");

        topic.register(observer1);
        topic.register(observer2);
        topic.register(observer3);
        topic.register(observer2);

        observer1.setSubject(topic);
        observer2.setSubject(topic);
        observer3.setSubject(topic);

        observer1.update();

        topic.postMessage("Yeah Finally Testing!");
    }
}
