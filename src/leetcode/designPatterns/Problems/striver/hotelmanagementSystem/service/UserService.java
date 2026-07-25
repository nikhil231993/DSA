package leetcode.designPatterns.Problems.striver.hotelmanagementSystem.service;

import leetcode.designPatterns.Problems.striver.hotelmanagementSystem.domain.Booking;
import leetcode.designPatterns.Problems.striver.hotelmanagementSystem.repository.BookingRepository;

import java.util.List;

public class UserService {
    private BookingRepository bookingRepository;

    public UserService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> listUserBookings(String userId) {
        return bookingRepository.findByUser(userId);
    }
}
