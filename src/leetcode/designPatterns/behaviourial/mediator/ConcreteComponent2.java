package leetcode.designPatterns.behaviourial.mediator;

public class ConcreteComponent2  extends  Component{

    public ConcreteComponent2(Mediator mediator){
        this.mediator=mediator;
        this.mediator.addComponent(this);
    }

    public void bid(int amount){
        this.mediator.notify(this, amount);
    }

    public void notifyBidValue(int amount){
        System.out.println("Bid Value is : " + amount);
    }
}
