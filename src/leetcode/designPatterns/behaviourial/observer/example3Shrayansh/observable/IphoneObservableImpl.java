package leetcode.designPatterns.behaviourial.observer.example3Shrayansh.observable;

import leetcode.designPatterns.behaviourial.observer.example3Shrayansh.observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservableImpl implements StockObservable {

    private List<NotificationAlertObserver> observerList=new ArrayList<>();
    private int count=0;

    @Override
    public void add(NotificationAlertObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void remove(NotificationAlertObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifySubscribers() {
        for(NotificationAlertObserver obs : observerList){
            obs.update();
        }
    }

    @Override
    public void setStockCount(int newStockAdded) {
        if(this.count==0){
            this.count=newStockAdded;
            notifySubscribers();
        }
        this.count=newStockAdded;
    }

    @Override
    public int getStockCount() {
        return this.count;
    }
}
