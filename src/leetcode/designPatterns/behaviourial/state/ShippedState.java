package leetcode.designPatterns.behaviourial.state;

public class ShippedState extends State{

    void select(StateController stateController) throws Exception{
        throw new Exception("Invalid selection");
    }

    void checkout(StateController stateController) throws Exception{
        throw new Exception("Invalid selection");
    }

    void payment(StateController stateController) throws Exception{
        throw new Exception("Invalid selection");
    }

    void shipped(StateController stateController){
        System.out.println("Item shipped");
    }
}
