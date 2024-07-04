package leetcode.designPatterns.behaviourial.command.uber;

public class RideService {

    public void requestRide(String passenger, String from, String to){
        System.out.println("Ride has been booked for passenger: "+passenger +" from: "+ from +" to: "+ to);
    }

    public void cancelRide(String passenger){
        System.out.println("Ride has been cancelled for passenger: "+ passenger);
    }
}
