package leetcode.designPatterns.behaviourial.state;

public class IdleState extends State{

    void select(StateController stateController){
        System.out.println("Item selected");
        stateController.setState(new CheckoutState());
    }

    void checkout(StateController stateController) throws Exception{
        throw new Exception("Invalid selection");
    }

    void payment(StateController stateController) throws Exception{
        throw new Exception("Invalid selection");
    }

    void shipped(StateController stateController) throws Exception{
        throw new Exception("Invalid selection");
    }
}
