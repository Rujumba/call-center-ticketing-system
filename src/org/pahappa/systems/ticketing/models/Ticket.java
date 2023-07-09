package org.pahappa.systems.ticketing.models;

import org.pahappa.systems.ticketing.constants.TicketCategory;
import org.pahappa.systems.ticketing.constants.TicketPriority;
import org.pahappa.systems.ticketing.constants.TicketStatus;

/**
 * A ticket refers to a unit of work or a request that is submitted
 * by a user or customer to seek assistance, report an issue, or request a
 * service.
 * It serves as a record or a container that captures all the relevant
 * information
 * related to the user's request or issue.
 */
public class Ticket {
    private String ticketId;
    private String ticketDescription;
    private TicketStatus ticketStatus;
    private TicketPriority ticketPriority;
    private TicketCategory ticketCategory;
    private String clientName;
    private String clientContact;
    // create getters and setters for the ticket attributes

    public String getTicketId() {
        return ticketId;
    }

    public String setTicketId(String ticketId) {
        return this.ticketId = ticketId;
    }

    public String getTicketDescription() {
        return ticketDescription;
    }

    public String setTicketDescription(String ticketDescription) {
        return this.ticketDescription = ticketDescription;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }   

    public TicketStatus setTicketStatus(TicketStatus ticketStatus) {
        return this.ticketStatus = ticketStatus;
    }

    public TicketPriority getTicketPriority() {
        return ticketPriority;
    }

    public TicketPriority setTicketPriority(TicketPriority ticketPriority) {
        return this.ticketPriority = ticketPriority;
    }

    public TicketCategory getTicketCategory() {
        return ticketCategory;
    }

    public TicketCategory setTicketCategory(TicketCategory ticketCategory) {
        return this.ticketCategory = ticketCategory;
    }

    public String getClientName() {
        return clientName;
    }

    public String setClientName(String clientName) {
        return this.clientName = clientName;
    }

    public String getClientContact() {
        return clientContact;
    }

    public String setClientContact(String clientContact) {
        return this.clientContact = clientContact;
    }

    

}