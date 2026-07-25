package leetcode.designPatterns.Problems.striver.ParkingLot.service;

import leetcode.designPatterns.Problems.striver.ParkingLot.domain.Ticket;
import leetcode.designPatterns.Problems.striver.ParkingLot.domain.Vehicle;
import leetcode.designPatterns.Problems.striver.ParkingLot.repository.TicketRepository;

import java.util.Optional;
import java.util.UUID;

public class TicketService {
    private TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket generateTicket(Vehicle vehicle, UUID slotId) {
        System.out.println("[SERVICE] Generating ticket for vehicle: " + vehicle.getLicensePlate());

        Ticket ticket = new Ticket(vehicle.getId(), slotId);
        ticketRepository.save(ticket);

        System.out.println("[SERVICE] Ticket generated successfully: " + ticket.getId());
        return ticket;
    }

    public Optional<Ticket> getTicket(UUID ticketId) {
        System.out.println("[SERVICE] Retrieving ticket: " + ticketId);
        return ticketRepository.findById(ticketId);
    }

    public void deactivateTicket(UUID ticketId) {
        System.out.println("[SERVICE] Deactivating ticket: " + ticketId);
        ticketRepository.deactivateTicket(ticketId);
    }


}
