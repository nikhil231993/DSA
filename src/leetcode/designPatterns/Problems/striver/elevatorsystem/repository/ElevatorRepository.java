package leetcode.designPatterns.Problems.striver.elevatorsystem.repository;

import leetcode.designPatterns.Problems.striver.elevatorsystem.domain.Elevator;

import java.util.List;
import java.util.Optional;

public interface ElevatorRepository {
    Elevator save(Elevator elevator);
    Optional<Elevator> findById(String elevatorId);
    List<Elevator> findByBuilding(String buildingId);
    List<Elevator> findAvailableElevators(String buildingId);
    void deleteById(String elevatorId);
}