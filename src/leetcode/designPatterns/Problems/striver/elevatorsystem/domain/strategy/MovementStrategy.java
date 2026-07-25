package leetcode.designPatterns.Problems.striver.elevatorsystem.domain.strategy;

import leetcode.designPatterns.Problems.striver.elevatorsystem.domain.Elevator;
import leetcode.designPatterns.Problems.striver.elevatorsystem.domain.InternalRequest;

import java.util.List;

public interface MovementStrategy {
    List<Integer> calculatePath(Elevator elevator, List<InternalRequest> requests);
}
