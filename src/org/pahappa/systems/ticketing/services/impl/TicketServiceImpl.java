package org.pahappa.systems.ticketing.services.impl;

import org.pahappa.systems.ticketing.constants.TicketStatus;
import org.pahappa.systems.ticketing.models.Ticket;
import org.pahappa.systems.ticketing.services.TicketService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TicketServiceImpl implements TicketService {
    // create a list of tickets
    private List<Ticket> tickets = new ArrayList<>();

    @Override
    public void createTicket(Ticket ticket) {
        // add ticket to the list
        Random random = new Random();
        ticket.ticketId = "T00" + random.nextInt(1000);

        tickets.add(ticket);

        System.out.println("\nTicket created successfully!");

    }

    @Override
    public List<Ticket> getAllTickets() {
        // return all tickets in the list

        return tickets;
    }

    @Override
    public List<Ticket> getTicketsOfStatus(TicketStatus ticketStatus) {
        return null;
    }

    @Override
    public void updateTicket(Ticket updatedTicket) {

    }

    @Override
    public void deleteTicket(int index) {

    }
}