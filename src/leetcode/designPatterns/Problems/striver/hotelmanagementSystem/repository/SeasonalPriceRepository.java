package leetcode.designPatterns.Problems.striver.hotelmanagementSystem.repository;

import leetcode.designPatterns.Problems.striver.hotelmanagementSystem.domain.SeasonalPrice;

import java.util.Optional;

public interface SeasonalPriceRepository {
    SeasonalPrice upsert(SeasonalPrice price);

    Optional<SeasonalPrice> findByKey(String hotelId, String roomTypeId, long dateUtc);
}
