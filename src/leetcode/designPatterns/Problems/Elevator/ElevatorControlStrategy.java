package leetcode.designPatterns.Problems.Elevator;

public interface ElevatorControlStrategy {

    //It has List<Stops> and as and when we get stops we add it and this strategy will determine and tell elevator where to stop
    int determineNextStop(int floorNum);
}
