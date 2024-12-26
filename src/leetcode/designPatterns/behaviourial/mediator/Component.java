package leetcode.designPatterns.behaviourial.mediator;

public abstract class Component {

    public Mediator mediator;

    abstract void bid(int amount);

    abstract void notifyBidValue(int amount);
}
