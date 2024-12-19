package leetcode.designPatterns.behaviourial.observer.example2;

import java.util.ArrayList;
import java.util.List;

public class IObservableFoodOrderStatusTracker implements IObservableStatusTracker{

    List<IObserver> oberverList=new ArrayList<>();

    @Override
    public void register(IObserver observer) {
        oberverList.add(observer);
    }

    @Override
    public void unregister(IObserver observer) {
        oberverList.remove(observer);
    }

    @Override
    public void notifyObservers(Order order) {
        for(IObserver obs:oberverList){
            obs.update(order);
        }
    }
}
