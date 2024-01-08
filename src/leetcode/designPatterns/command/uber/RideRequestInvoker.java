package leetcode.designPatterns.command.uber;

public class RideRequestInvoker {

    public void processRequest(Command command){
        command.execute();
    }
}
