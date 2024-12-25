package leetcode.designPatterns.Problems.Elevator;

public class ExternalRequestsProcessor {

    private ElevatorSelectionStrategy elevatorSelectionStrategy;

    public ExternalRequestsProcessor() {
        // Setting default elevator selection strategy
        elevatorSelectionStrategy = new OddEvenElevatorSelStrategy();
    }

    public void setElevatorSelectionStrategy(ElevatorSelectionStrategy selectionStrategy) {
        elevatorSelectionStrategy = selectionStrategy;
    }

    public void processExternalRequest(ExternalRequest extReq) {

        int assignedElevatorId = elevatorSelectionStrategy.selectElevator(extReq);
        //Got elevator ID from SelectionStrategy
        ElevatorMgr elevatorMgr = ElevatorMgr.getElevatorMgr();
        Elevator assignedElevator = elevatorMgr.getElevator(assignedElevatorId);
        //Above line fetches the elevator Object
        //Below line will add the src floor to the stops and tells elevator to move
        assignedElevator.moveToFloor(extReq.getSrcFloor());
    }
}
