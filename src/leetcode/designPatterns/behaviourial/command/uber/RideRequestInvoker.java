package leetcode.designPatterns.behaviourial.command.uber;

public class RideRequestInvoker {

    public void processRequest(Command command){
        command.execute();
    }
}
