package leetcode.designPatterns.behaviourial.observer.example2Shrayansh;

import leetcode.designPatterns.behaviourial.observer.example2Shrayansh.observable.IphoneObservableImpl;
import leetcode.designPatterns.behaviourial.observer.example2Shrayansh.observable.StockObservable;
import leetcode.designPatterns.behaviourial.observer.example2Shrayansh.observer.EmailAlertObserverImpl;
import leetcode.designPatterns.behaviourial.observer.example2Shrayansh.observer.MobileAlterObserverImpl;
import leetcode.designPatterns.behaviourial.observer.example2Shrayansh.observer.NotificationAlertObserver;

public class Main {

    public static void main(String[] args) {

        StockObservable observable=new IphoneObservableImpl();

        NotificationAlertObserver emailAlertObserver=new EmailAlertObserverImpl("Nikhil@gmail.com", observable);
        NotificationAlertObserver mobileAlertObserver=new MobileAlterObserverImpl("Nikhil@gmail.com", observable);

        observable.add(emailAlertObserver);
        observable.add(mobileAlertObserver);

        observable.setStockCount(10);
        observable.setStockCount(0);
        observable.setStockCount(100);
    }
}
