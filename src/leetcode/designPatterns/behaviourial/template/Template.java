package leetcode.designPatterns.behaviourial.template;

public abstract class  Template {

    public final void processOrder(){
        //This has to be noted that this method is final so that the child class do not override it
        verifyOrder();
        assignDeliveryAgent();
        trackDelivery();
    }

    public abstract void verifyOrder();

    public abstract void assignDeliveryAgent();

    public abstract void trackDelivery();
}
