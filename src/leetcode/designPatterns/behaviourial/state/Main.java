package leetcode.designPatterns.behaviourial.state;

public class Main {

    public static void main(String[] args) throws Exception {

        StateController stateController=new StateController();
        stateController.getState().select(stateController);
        stateController.getState().checkout(stateController);


    }
}
