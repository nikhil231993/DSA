package leetcode.designPatterns.behaviourial.observer.example1;

import java.util.ArrayList;
import java.util.List;

public class OrderStatusTracker implements ITracker { //This is subject or observable

    private List<Order> orderList=new ArrayList<>();

    private List<Observer> observers=new ArrayList<>();

    public void registerObservers(Observer observer){
        observers.add(observer);
    }

    public void unregisterObservers(Observer observer){
        observers.remove(observer);
    }

    public void addOrder(Order order){
        orderList.add(order);
        notifyObservers(order);
    }

    public void notifyObservers(Order order){ //This method cab ne private but in that case we have to extend a class
        // as in interface methods by default are public
        for(Observer observer:observers){
            observer.update(order);
        }
    }
}
