package leetcode.designPatterns.behaviourial.state;

public abstract class State {

    abstract void select(StateController stateController) throws Exception;

    abstract void checkout(StateController stateController)  throws Exception;

    abstract void payment(StateController stateController)  throws Exception;

    abstract void shipped(StateController stateController) throws Exception;
}
