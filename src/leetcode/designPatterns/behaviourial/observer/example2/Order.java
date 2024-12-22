package leetcode.designPatterns.behaviourial.observer.example2;

public class Order {

    private String id;
    private String name;
    public IObservableStatusTracker tracker;

    public Order(String id, String name){
        this.id=id;
        this.name=name;
        tracker=new IObservableFoodOrderStatusTracker();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void updateStatus(Order order){
        this.tracker.notifyObservers(order); // we can use this here and no need to pass order above
    }
}
