package ObserverDesignPattern;

public interface Subject {
    public void register(Observer observer);
    public void deregister(Observer observer);

    public void notifyAllObservers();
    public String getUpdate(Observer observer);
}
