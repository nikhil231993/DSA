package leetcode.designPatterns.behaviourial.template;

public abstract class  Template {

    public final void processOrder(){
        verifyOrder();
        assignDeliveryAgent();
        trackDelivery();
    }

    public abstract void verifyOrder();

    public abstract void assignDeliveryAgent();

    public abstract void trackDelivery();
}
