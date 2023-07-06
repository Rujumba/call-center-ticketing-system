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
    public String ticketId;
    public String ticketName;
    public String ticketDescription;
    public TicketStatus ticketStatus;
    public TicketPriority ticketPriority;
    public TicketCategory ticketCategory;
    public String clientName;
    public String clientContact;
    // create getters and setters for the ticket attributes

}