package leetcode.designPatterns.behaviourial.state;

public class CheckoutState extends State{

    void select(StateController stateController) throws Exception{
        throw new Exception("Invalid selection");
    }

    void checkout(StateController stateController){
        System.out.println("Item checkout");
    }

    void payment(StateController stateController) throws Exception{
        throw new Exception("Invalid selection");
    }

    void shipped(StateController stateController) throws Exception{
        throw new Exception("Invalid selection");
    }
}
