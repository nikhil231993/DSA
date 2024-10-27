package leetcode.designPatterns.behaviourial.observer.example1;

public class Order {

    private String name;

    private Integer orderId;

    private String status;

    public Order(String name, Integer orderId, String status) {
        this.name = name;
        this.orderId = orderId;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public String getStatus() {
        return status;
    }
}
