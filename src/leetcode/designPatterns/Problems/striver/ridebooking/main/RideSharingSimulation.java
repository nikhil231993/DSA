package leetcode.designPatterns.Problems.striver.ridebooking.main;

import leetcode.designPatterns.Problems.striver.ridebooking.controller.DriverController;
import leetcode.designPatterns.Problems.striver.ridebooking.controller.PaymentController;
import leetcode.designPatterns.Problems.striver.ridebooking.controller.RideController;
import leetcode.designPatterns.Problems.striver.ridebooking.domain.*;
import leetcode.designPatterns.Problems.striver.ridebooking.domain.strategy.BasePricingStrategy;
import leetcode.designPatterns.Problems.striver.ridebooking.domain.strategy.NearestDriverStrategy;
import leetcode.designPatterns.Problems.striver.ridebooking.repository.DriverRepository;
import leetcode.designPatterns.Problems.striver.ridebooking.repository.LocationRepository;
import leetcode.designPatterns.Problems.striver.ridebooking.repository.RideRepository;
import leetcode.designPatterns.Problems.striver.ridebooking.repository.RiderRepository;
import leetcode.designPatterns.Problems.striver.ridebooking.repository.impl.InMemoryDriverRepository;
import leetcode.designPatterns.Problems.striver.ridebooking.repository.impl.InMemoryLocationRepository;
import leetcode.designPatterns.Problems.striver.ridebooking.repository.impl.InMemoryRideRepository;
import leetcode.designPatterns.Problems.striver.ridebooking.repository.impl.InMemoryRiderRepository;
import leetcode.designPatterns.Problems.striver.ridebooking.service.*;
import leetcode.designPatterns.Problems.striver.ridebooking.service.notification.NotificationService;

public class RideSharingSimulation {
    public static void main(String[] args) {
        RideRepository rideRepository = new InMemoryRideRepository();
        RiderRepository riderRepository = new InMemoryRiderRepository();
        DriverRepository driverRepository = new InMemoryDriverRepository();
        LocationRepository locationRepository = new InMemoryLocationRepository();

        Rider rider = new Rider("rider-1", "Alice Rider", "alice@example.com", "111-222-3333",
                System.currentTimeMillis());
        riderRepository.save(rider);

        Driver driver = new Driver("driver-1", "Bob Driver", "bob@example.com", "444-555-6666", "KA01AB1234", "Sedan",
                DriverStatus.ONLINE);
        driver.setCurrentLocation(new Location(37.7749, -122.4194, "Market St", System.currentTimeMillis()));
        driverRepository.save(driver);

        NotificationService notificationService = new NotificationService();
        PricingService pricingService = new PricingService(new BasePricingStrategy());
        LocationService locationService = new LocationService(locationRepository);
        LockService lockService = new LockService();
        MatchingService matchingService = new MatchingService(driverRepository, rideRepository,
                new NearestDriverStrategy(), lockService, notificationService);
        PaymentService paymentService = new PaymentService(rideRepository, notificationService);
        RideService rideService = new RideService(rideRepository, riderRepository, driverRepository, matchingService,
                pricingService, paymentService, notificationService, locationService, lockService);
        DriverService driverService = new DriverService(driverRepository);

        RideController rideController = new RideController(rideService);
        DriverController driverController = new DriverController(driverService, rideService);
        PaymentController paymentController = new PaymentController(rideService);

        Location pickup = new Location(37.7749, -122.4194, "Market St", System.currentTimeMillis());
        Location drop = new Location(37.7840, -122.4090, "Mission St", System.currentTimeMillis());
        RideRequest prePaymentRequest = new RideRequest(rider.getId(), pickup, drop, PaymentType.PRE_PAYMENT);

        System.out.println("--- Requesting ride with PRE_PAYMENT ---");
        Ride ride = rideController.requestRide(prePaymentRequest);
        System.out.println("Ride created with id " + ride.getId() + " paymentId=" + ride.getPaymentId());

        paymentController.handleCallback(ride.getPaymentId(), PaymentStatus.COMPLETED);
        driverController.acceptRide(ride.getId(), driver.getId());
        driverController.startRide(ride.getId(), driver.getId());
        driverController.completeRide(ride.getId(), driver.getId());
        RideStatusResponse completedStatus = rideController.getRideStatus(ride.getId());
        System.out
                .println("Ride status: " + completedStatus.getStatus() + " fare=" + completedStatus.getEstimatedFare());

        System.out.println("--- Requesting ride with POST_PAYMENT (cash) ---");
        RideRequest postPaymentRequest = new RideRequest(rider.getId(), pickup, drop, PaymentType.POST_PAYMENT);
        Ride cashRide = rideController.requestRide(postPaymentRequest);
        driverController.acceptRide(cashRide.getId(), driver.getId());
        driverController.startRide(cashRide.getId(), driver.getId());
        driverController.completeRide(cashRide.getId(), driver.getId());
        RideStatusResponse cashStatus = rideController.getRideStatus(cashRide.getId());
        System.out.println("Cash ride status: " + cashStatus.getStatus() + " fare=" + cashStatus.getEstimatedFare());
    }
}
