package leetcode.designPatterns.Problems.striver.elevatorsystem.repository;

import leetcode.designPatterns.Problems.striver.elevatorsystem.domain.Building;

import java.util.List;
import java.util.Optional;

public interface BuildingRepository {
    Building save(Building building);
    Optional<Building> findById(String buildingId);
    List<Building> findAll();
    void deleteById(String buildingId);
}