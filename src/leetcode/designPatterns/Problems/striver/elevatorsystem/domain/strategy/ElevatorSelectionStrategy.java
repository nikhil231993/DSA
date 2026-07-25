package leetcode.designPatterns.Problems.striver.elevatorsystem.domain.strategy;

import leetcode.designPatterns.Problems.striver.elevatorsystem.domain.Elevator;
import leetcode.designPatterns.Problems.striver.elevatorsystem.domain.ExternalRequest;

import java.util.List;

public interface ElevatorSelectionStrategy {
    Elevator selectElevator(ExternalRequest request, List<Elevator> availableElevators);
}