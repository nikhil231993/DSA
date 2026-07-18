package leetcode.designPatterns.behaviourial.state;

public class Main {

    public static void main(String[] args) throws Exception {

        StateController stateController=new StateController();
        stateController.getState().select(stateController);
        System.out.println(stateController.getState());
        stateController.getState().checkout(stateController);
        System.out.println(stateController.getState());
    }
}
