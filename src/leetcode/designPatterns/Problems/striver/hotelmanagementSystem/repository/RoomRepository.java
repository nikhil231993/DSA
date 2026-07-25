package leetcode.designPatterns.Problems.striver.hotelmanagementSystem.repository;

import leetcode.designPatterns.Problems.striver.hotelmanagementSystem.domain.Room;

import java.util.List;

public interface RoomRepository {
    Room save(Room room);

    List<Room> findByHotelAndType(String hotelId, String roomTypeId);
}
