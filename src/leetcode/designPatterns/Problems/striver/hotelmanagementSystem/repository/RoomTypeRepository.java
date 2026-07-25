package leetcode.designPatterns.Problems.striver.hotelmanagementSystem.repository;

import leetcode.designPatterns.Problems.striver.hotelmanagementSystem.domain.RoomType;

import java.util.List;
import java.util.Optional;

public interface RoomTypeRepository {
    RoomType save(RoomType roomType);

    Optional<RoomType> findById(String roomTypeId);

    List<RoomType> findByHotel(String hotelId);
}
