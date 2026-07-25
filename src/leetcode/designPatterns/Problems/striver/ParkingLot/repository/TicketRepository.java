package leetcode.designPatterns.Problems.striver.ParkingLot.repository;

import leetcode.designPatterns.Problems.striver.ParkingLot.domain.Ticket;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class TicketRepository {
    private Map<UUID, Ticket> tickets = new ConcurrentHashMap<>();

    public Ticket save(Ticket ticket) {
        tickets.put(ticket.getId(), ticket);
        return ticket;
    }

    public Optional<Ticket> findById(UUID ticketId) {
        return Optional.ofNullable(tickets.get(ticketId));
    }

    public List<Ticket> findActiveTickets() {
        return tickets.values().stream()
                .filter(Ticket::isActive)
                .collect(Collectors.toList());
    }

    public void deactivateTicket(UUID ticketId) {
        tickets.computeIfPresent(ticketId, (id, ticket) -> {
            ticket.deactivate();
            return ticket;
        });
    }

    public void clear() {
        tickets.clear();
    }
}
