package leetcode.designPatterns.command.uber;

public class CancelRideCommand implements Command{

    private RideService rideService;
    private String passenger;

    public CancelRideCommand(RideService rideService, String passenger){
        this.rideService=rideService;
        this.passenger=passenger;
    }

    @Override
    public void execute() {
        this.rideService.cancelRide(passenger);
    }
}
