package leetcode.designPatterns.command.uber;

public class RequestRideCommand implements Command{

    private RideService rideService;
    private String passenger;
    private String from;
    private String to;

    public RequestRideCommand(RideService rideService, String passenger, String from, String to){
        this.rideService=rideService;
        this.passenger=passenger;
        this.from=from;
        this.to=to;
    }
    @Override
    public void execute() {
        this.rideService.requestRide(passenger,from,to);
    }
}
