package leetcode.designPatterns.behaviourial.observer.example3Shrayansh.observable;

import leetcode.designPatterns.behaviourial.observer.example3Shrayansh.observer.NotificationAlertObserver;

public interface StockObservable {

    public void add(NotificationAlertObserver observer);

    public void remove(NotificationAlertObserver observer);

    public void notifySubscribers();

    public void setStockCount(int newStockAdded);

    public int getStockCount();
}
