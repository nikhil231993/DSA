package leetcode.designPatterns.behaviourial.observer.example2;

import java.util.ArrayList;
import java.util.List;

public interface IObservableStatusTracker {

    void register(IObserver observer);

    void unregister(IObserver observer);

    void notifyObservers(Order order);
}
