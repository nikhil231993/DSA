package leetcode.designPatterns.behaviourial.state;

public class PaymentState extends State {

    void select(StateController stateController) throws Exception{
        throw new Exception("Invalid selection");
    }

    void checkout(StateController stateController) throws Exception{
        throw new Exception("Invalid selection");
    }

    void payment(StateController stateController){
        System.out.println("Payment checkout");
        stateController.setState(new CheckoutState());
    }

    void shipped(StateController stateController) throws Exception{
        throw new Exception("Invalid selection");
    }
}
