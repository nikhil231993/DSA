package LowLevelDesign.Elevator;

import java.util.HashMap;

public class FirstComeFirstServeElevatorControlStrategy implements ElevatorControlStrategy {

    private ElevatorCurrState status=null;
    private HashMap<String, String> map=null;
    @Override
    public int determineNextStop(int floorNum) {

         HashMap<String, String> map=new HashMap<>();

        status=new ElevatorCurrState();
        // synchronized (this) {
             if (floorNum == 1) {
                 map.put("Nikhil","Hi");
                 System.out.println("if"+ map + map.hashCode());
                 System.out.println("if block:" + status.hashCode());
                 status.setCurrStatus(ElevatorStatus.STOPPED);
                 try {
                     Thread.sleep(10000);
                 } catch (InterruptedException e) {
                     throw new RuntimeException(e);
                 }
             } else {
                 map.put("Keerti","hi");
                 System.out.println("else"+ map + map.hashCode());
                 System.out.println("else block:" + status.hashCode());
                 status.setCurrStatus(ElevatorStatus.MOVING);
                 try {
                     Thread.sleep(20000);
                 } catch (InterruptedException e) {
                     throw new RuntimeException(e);
                 }
           //  }
         }

        System.out.println("Applying First Come First Serve Algorithm and Moving elevator to floor " + status.hashCode()+" floor No "+floorNum +" "+ status.getCurrStatus() +" "+ map +" "+ map.hashCode());
        //returning 1 for demo purposes, should be determining next stop and returning that
        return 1;
    }
}