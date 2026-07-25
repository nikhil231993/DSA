package leetcode.designPatterns.Problems.striver.ParkingLot.adapter;

import java.util.UUID;

public interface PaymentGatewayAdapter {
    boolean pay(UUID ticketId, double amount);
}
