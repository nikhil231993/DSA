package leetcode.designPatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class OrderTracker {

    private List<Order> orderList=new ArrayList<>();

    private List<Observer> observers=new ArrayList<>();

    public void register(Observer observer){
        observers.add(observer);
    }

    public void unregister(Observer observer){
        observers.remove(observer);
    }

    public void addOrder(Order order){
        orderList.add(order);
        notifyObservers(order);
    }

    private void notifyObservers(Order order){
        for(Observer observer:observers){
            observer.update(order);
        }
    }
}
