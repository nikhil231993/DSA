package leetcode.designPatterns.Problems.striver.hotelmanagementSystem.controller;

import leetcode.designPatterns.Problems.striver.hotelmanagementSystem.domain.DateRange;
import leetcode.designPatterns.Problems.striver.hotelmanagementSystem.domain.Hotel;
import leetcode.designPatterns.Problems.striver.hotelmanagementSystem.domain.RoomTypeAvailability;
import leetcode.designPatterns.Problems.striver.hotelmanagementSystem.domain.SearchFilter;
import leetcode.designPatterns.Problems.striver.hotelmanagementSystem.service.SearchService;

import java.util.List;

public class SearchController {
    private SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    public List<Hotel> searchHotels(SearchFilter filter) {
        return searchService.searchHotels(filter);
    }

    public List<RoomTypeAvailability> getAvailability(String hotelId, DateRange range) {
        return searchService.getAvailability(hotelId, range);
    }
}
