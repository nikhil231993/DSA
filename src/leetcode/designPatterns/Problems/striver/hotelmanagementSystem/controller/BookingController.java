package leetcode.designPatterns.Problems.striver.hotelmanagementSystem.controller;

import leetcode.designPatterns.Problems.striver.hotelmanagementSystem.domain.Booking;
import leetcode.designPatterns.Problems.striver.hotelmanagementSystem.domain.DateRange;
import leetcode.designPatterns.Problems.striver.hotelmanagementSystem.service.BookingService;

public class BookingController {
    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public Booking createBooking(String userId, String hotelId, String roomTypeId, DateRange range,
                                 long expectedTotalPrice) {
        return bookingService.createBooking(userId, hotelId, roomTypeId, range, expectedTotalPrice);
    }

    public void cancelBooking(String bookingId, String userId) {
        bookingService.cancelBooking(bookingId, userId);
    }
}
