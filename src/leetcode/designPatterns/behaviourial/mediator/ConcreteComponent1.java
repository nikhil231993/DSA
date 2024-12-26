package leetcode.designPatterns.behaviourial.mediator;

public class ConcreteComponent1 extends Component{

    public ConcreteComponent1(Mediator mediator){
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
