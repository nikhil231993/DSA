package leetcode.designPatterns.template;

public class LocalOrderProcessor extends Template {

    @Override
    public void verifyOrder() {
        System.out.println("Verify Local Order");
    }

    @Override
    public void assignDeliveryAgent() {
        System.out.println("Assign Delivery Agent for Local Order");
    }

    @Override
    public void trackDelivery() {
        System.out.println("Track Local Delivery Order");
    }
}
