package leetcode.designPatterns.Problems.Elevator;

public class Main {

    public static void main(String[] args) {

        // Initialize the Elevator system for 12 floors and 4 elevators
        ElevatorSystem elevatorSystem = ElevatorSystem.getElevatorSystem();
        elevatorSystem.initializeElevatorSystem(12, 4);

        elevatorSystem.setElevatorSelectionStrategy(new OddEvenElevatorSelStrategy());

        Thread t1=new Thread(()->elevatorSystem.sendExternalRequest(ElevatorDirection.DOWN, 1));
        Thread t2=new Thread(()->elevatorSystem.sendExternalRequest(ElevatorDirection.UP, 11));
        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        }catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }
        //System.out.println("--------------------------------------------------------");
        // Press external button from floor 10 to go down
        //elevatorSystem.sendExternalRequest(ElevatorDirection.DOWN, 10);

        //System.out.println("--------------------------------------------------------");
        // Press internal button to move to floor 7 in elevator 4
        //elevatorSystem.sendInternalRequest(7, 4);
        //System.out.println("--------------------------------------------------------");
    }
}
