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
        ticket.setTicketId("T00" + random.nextInt(1000));

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

        for (Ticket ticket : tickets) {
            if (ticket.getTicketStatus() == ticketStatus) {
                System.out.println("\n\n****Record" + (tickets.indexOf(ticket) + 1) + "****");
                System.out.println(
                        "Ticket ID: " + ticket.getTicketId() + "\n" + "Client Name: " + ticket.getClientName() + "\n"
                                + "Contact: " + ticket.getClientContact() + "\n" + "Description: "
                                + ticket.getTicketDescription() + "\n"
                                + "Category: " + ticket.getTicketCategory() + "\n"
                                + "Priority: " + ticket.getTicketPriority() + "\n");
            } else {
                System.out.println("\nNo tickets found\n\n");
            }
        }
        return null;
    }

    @Override
    public void updateTicket(Ticket updatedTicket) {

    }

    @Override
    public void deleteTicket(int index) {

    }
}