package leetcode.designPatterns.behaviourial.mediator;

public class Main {

    public static void main(String[] args) {

        Mediator mediator=new Mediator();
        Component bidder1=new ConcreteComponent1(mediator);
        Component bidder2=new ConcreteComponent2(mediator);
        Component bidder3=new ConcreteComponent3(mediator);
        bidder1.bid(100);

        bidder1.bid(200);
    }
}
