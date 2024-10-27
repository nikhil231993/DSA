package leetcode.designPatterns.behaviourial.observer.example2Shrayansh.observer;

import leetcode.designPatterns.behaviourial.observer.example2Shrayansh.observable.StockObservable;

public class MobileAlterObserverImpl implements NotificationAlertObserver {

    private StockObservable observable;
    private String email;

    public MobileAlterObserverImpl(String email, StockObservable observable){
        this.email=email;
        this.observable=observable;
    }
    @Override
    public void update() {
        System.out.println("Mobile alert has been sent to " + this.email+ " " + this.observable.getStockCount());
    }
}
