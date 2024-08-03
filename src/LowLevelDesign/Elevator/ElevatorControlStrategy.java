package LowLevelDesign.Elevator;

public interface ElevatorControlStrategy {

    int determineNextStop(int floorNum);
}
