package leetcode.designPatterns.Problems.striver.hotelmanagementSystem.service;

import leetcode.designPatterns.Problems.striver.hotelmanagementSystem.domain.DateRange;
import leetcode.designPatterns.Problems.striver.hotelmanagementSystem.domain.NightlyPrice;
import leetcode.designPatterns.Problems.striver.hotelmanagementSystem.domain.RoomType;
import leetcode.designPatterns.Problems.striver.hotelmanagementSystem.domain.SeasonalPrice;
import leetcode.designPatterns.Problems.striver.hotelmanagementSystem.repository.RoomTypeRepository;
import leetcode.designPatterns.Problems.striver.hotelmanagementSystem.repository.SeasonalPriceRepository;
import leetcode.designPatterns.Problems.striver.ridebooking.domain.strategy.PricingStrategy;

import java.util.*;

public class PricingService {
    private RoomTypeRepository roomTypeRepository;
    private SeasonalPriceRepository seasonalPriceRepository;
    private PricingStrategy pricingStrategy;

    public PricingService(PricingStrategy pricingStrategy){
        this.pricingStrategy = pricingStrategy;
    }

    public PricingService(RoomTypeRepository roomTypeRepository, SeasonalPriceRepository seasonalPriceRepository) {
        this.roomTypeRepository = roomTypeRepository;
        this.seasonalPriceRepository = seasonalPriceRepository;
    }

    public List<NightlyPrice> rateStay(String hotelId, String roomTypeId, DateRange range) {
        Optional<RoomType> roomTypeOpt = roomTypeRepository.findById(roomTypeId);
        if (roomTypeOpt.isEmpty()) {
            return Collections.emptyList();
        }
        RoomType roomType = roomTypeOpt.get();
        long basePrice = roomType.getBasePrice();

        List<NightlyPrice> nightlyPrices = new ArrayList<>();
        for (long dateUtc = range.getCheckInDateUtc(); dateUtc < range.getCheckOutDateUtc(); dateUtc += 86400000) {
            // Check for seasonal price, fallback to basePrice
            Optional<SeasonalPrice> seasonalPriceOpt = seasonalPriceRepository.findByKey(hotelId, roomTypeId, dateUtc);
            long price = seasonalPriceOpt.map(SeasonalPrice::getPriceMinor).orElse(basePrice);
            nightlyPrices.add(new NightlyPrice(dateUtc, price));
        }
        return nightlyPrices;
    }

    public long computeTotal(List<NightlyPrice> nightly) {
        return nightly.stream()
                .mapToLong(NightlyPrice::getPriceMinor)
                .sum();
    }

    public double computeAveragePricePerNight(List<NightlyPrice> nightly, int numberOfNights) {
        if (numberOfNights == 0) {
            return 0.0;
        }
        return (double) computeTotal(nightly) / numberOfNights;
    }
}
