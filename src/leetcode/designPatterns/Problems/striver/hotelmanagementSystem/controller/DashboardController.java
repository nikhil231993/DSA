package leetcode.designPatterns.Problems.striver.hotelmanagementSystem.controller;

import leetcode.designPatterns.Problems.striver.hotelmanagementSystem.domain.Booking;
import leetcode.designPatterns.Problems.striver.hotelmanagementSystem.service.UserService;

import java.util.List;

public class DashboardController {
    private UserService userService;

    public DashboardController(UserService userService) {
        this.userService = userService;
    }

    public List<Booking> listUserBookings(String userId) {
        return userService.listUserBookings(userId);
    }
}
