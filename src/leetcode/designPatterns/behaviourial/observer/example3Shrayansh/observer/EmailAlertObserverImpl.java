package leetcode.designPatterns.behaviourial.observer.example3Shrayansh.observer;

import leetcode.designPatterns.behaviourial.observer.example3Shrayansh.observable.StockObservable;

public class EmailAlertObserverImpl implements NotificationAlertObserver {

    private StockObservable observable;
    private String email;

    public EmailAlertObserverImpl(String email, StockObservable observable){
        this.email=email;
        this.observable=observable;
    }
    @Override
    public void update() {
        System.out.println("Email alert has been sent to " + this.email+ " " + this.observable.getStockCount());
    }
}
