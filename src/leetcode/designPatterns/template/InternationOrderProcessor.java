package leetcode.designPatterns.template;

public class InternationOrderProcessor extends Template{


    @Override
    public void verifyOrder() {
        System.out.println("Verify International Order");
    }

    @Override
    public void assignDeliveryAgent() {
        System.out.println("Assign Delivery Agent for International Order");
    }

    @Override
    public void trackDelivery() {
        System.out.println("Track International Delivery Order");
    }
}
