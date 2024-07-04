package leetcode.designPatterns.behaviourial.command.uber;

public class Main {

    public static void main(String[] args) {

        RideService rideService=new RideService();

        Command rideCommand=new RequestRideCommand(rideService, "Rakesh","Madiwala", "whitefield");
        Command cancelCommand=new CancelRideCommand(rideService, "Rakesh");

        RideRequestInvoker rideRequestInvoker=new RideRequestInvoker();
        rideRequestInvoker.processRequest(rideCommand);
        rideRequestInvoker.processRequest(cancelCommand);
    }
}
