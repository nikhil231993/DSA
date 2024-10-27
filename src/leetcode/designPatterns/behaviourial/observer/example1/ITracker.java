package leetcode.designPatterns.behaviourial.observer.example1;

public interface ITracker {

    void notifyObservers(Order order);

    void registerObservers(Observer observer);

     void unregisterObservers(Observer observer);
}
