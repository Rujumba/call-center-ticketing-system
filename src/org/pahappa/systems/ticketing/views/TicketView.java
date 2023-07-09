package org.pahappa.systems.ticketing.views;

import org.pahappa.systems.ticketing.constants.*;
import org.pahappa.systems.ticketing.models.*;
import org.pahappa.systems.ticketing.services.TicketService;
import org.pahappa.systems.ticketing.services.impl.TicketServiceImpl;

import java.util.List;
import java.util.Scanner;

public class TicketView implements BaseTicketView {

    private final TicketService ticketService;
    private final Scanner scanner;
    int maxAttempt = 0;

    public TicketView() {
        this.ticketService = new TicketServiceImpl();
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void displayMenu() {
        System.out.println("********* Call Center Ticket System *********\n\n");
        boolean running = true;
        while (running) {
            System.out.println("Choose an operation:");
            System.out.println("1. Create Ticket");
            System.out.println("2. Get All Tickets");
            System.out.println("3. Get Tickets of Status");
            System.out.println("4. Update Ticket");
            System.out.println("5. Delete Ticket");
            System.out.println("6. Exit");
            System.out.println();

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();
            scanner.nextLine(); // Consume the newline character

            // verify if choice is a regular expression
            if (choice.matches("[0-9]+")) {

                int choiceInt = Integer.parseInt(choice);
                switch (choiceInt) {
                    case 1:
                        createTicket();
                        scanner.nextLine();
                        break;
                    case 2:
                        getAllTickets();
                        scanner.nextLine();
                        break;
                    case 3:
                        getTicketsOfStatus();
                        break;
                    case 4:
                        updateTicket();
                        break;
                    case 5:
                        deleteTicket();
                        break;
                    case 6:
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid number choice. Please try again.");
                }
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    @Override
    public void createTicket() {

        Ticket obj = new Ticket();

        System.out.println("********* Create Ticket *********\n\n");

        /*---------------------ClientName----------------------------- */

        System.out.println("\nEnter the name of the client:");
        obj.setClientName(scanner.nextLine());

        /*---------------------TicketDescription----------------------------- */

        System.out.println("\nEnter the description of the ticket:");
        obj.setTicketDescription(scanner.nextLine());

        /*---------------------Client contact----------------------------- */

        System.out.println("\nEnter the contact of the client:");
        obj.setClientContact(scanner.nextLine());

        /*---------------------Ticket Priority----------------------------- */

        boolean valid = false;
        int k = 0;
        String priorityString;
        while (valid == false && maxAttempt < 3) {

            System.out.println("\nSelect ticket priority");
            for (TicketPriority ticketPriority : TicketPriority.values()) {
                System.out.println(++k + ". " + ticketPriority.name());
            }
            System.out.println("Enter your choice: ");
            priorityString = scanner.nextLine();

            if (priorityString.matches("[0-9]+")) {
                int priority = Integer.parseInt(priorityString);
                switch (priority) {
                    case 1:
                        obj.setTicketPriority(TicketPriority.LOW);
                        break;
                    case 2:
                        obj.setTicketPriority(TicketPriority.MEDIUM);
                        break;
                    case 3:
                        obj.setTicketPriority(TicketPriority.HIGH);
                        break;
                    default:
                        System.out.println("\nInvalid choice of priority. Please try again.");
                        break;

                }
                valid = true;
            } else {
                System.out.println("Words arent allowed");

            }
        }

        /*---------------------TicketCategory----------------------------- */

        boolean valid1 = false;

        maxAttempt = 0;
        while (valid == true && maxAttempt < 3 && valid1 == false) {
            int j = 0;
            System.out.println("\nSelect ticket category");

            for (TicketCategory ticketCategory : TicketCategory.values()) {
                System.out.println(++j + ". " + ticketCategory.name());
            }
            System.out.println("\nEnter your choice: ");

            String category = scanner.nextLine();

            if (category.matches("[0-9]+")) {
                int categoryInt = Integer.parseInt(category);
                switch (categoryInt) {
                    case 1:
                        obj.setTicketCategory(TicketCategory.COMPLAINT);
                        break;
                    case 2:
                        obj.setTicketCategory(TicketCategory.SUPPORT_ASSISTANCE);
                        break;
                    default:
                        System.out.println("\nInvalid choice of priority. Please try again.");
                        break;
                }
                valid1 = true;
            } else {
                System.out.println("Words arent allowed");
                scanner.nextLine();

            }
        }

        /*---------------------TicketStatus----------------------------- */

        boolean valid2 = false;
        maxAttempt = 0;
        while (valid == true && valid1 == true && valid2 == false && maxAttempt < 3) {
            int i = 0;
            System.out.println("\nSelect ticket status");

            for (TicketStatus ticketStatus : TicketStatus.values()) {
                System.out.println(++i + ". " + ticketStatus.name());
            }

            System.out.println("\nEnter your choice: ");

            String status = scanner.nextLine();
            scanner.nextLine();

            if (status.matches("[0-9]+")) {
                int statusInt = Integer.parseInt(status);
                switch (statusInt) {
                    case 1:
                        obj.setTicketStatus(TicketStatus.OPEN);
                        break;
                    case 2:
                        obj.setTicketStatus(TicketStatus.INPROGRESS);
                        break;
                    case 3:
                        obj.setTicketStatus(TicketStatus.RESOLVED);
                        break;
                    default:
                        System.out.println("\nInvalid choice of priority. Please try again.");
                        break;
                }
                ticketService.createTicket(obj);
                valid2 = true;
            } else {
                System.out.println("Words arent allowed" + "\n\n");
            }

        }

    }

    @Override
    public void getAllTickets() {
        System.out.println("********* Get All Tickets *********\n\n");
        List<Ticket> tickets = ticketService.getAllTickets();
        for (Ticket ticket : tickets) {
            System.out.println("Ticket ID: " + ticket.getTicketId());
            System.out.println("Client Name: " + ticket.getClientName());
            System.out.println("Ticket Description: " + ticket.getTicketDescription());
            System.out.println("Client Contact: " + ticket.getClientContact());
            System.out.println("Ticket Priority: " + ticket.getTicketPriority());
            System.out.println("Ticket Category: " + ticket.getTicketCategory());
            System.out.println("Ticket Status: " + ticket.getTicketStatus());

        }

    }

    @Override
    public void getTicketsOfStatus() {

        System.out.println("********* Tickets of Status *********\n\n");

        boolean valid = false;

        String priorityString;
        while (valid == false) {
            int k = 0;
            System.out.println("\nSelect ticket status");
            for (TicketStatus ticketStatus : TicketStatus.values()) {
                System.out.println(++k + ". " + ticketStatus.name());
            }
            System.out.println("Enter your choice: ");
            priorityString = scanner.nextLine();

            if (priorityString.matches("[0-9]+")) {
                int priority = Integer.parseInt(priorityString);
                switch (priority) {
                    case 1:
                        ticketService.getTicketsOfStatus(TicketStatus.OPEN);
                        break;
                    case 2:
                        ticketService.getTicketsOfStatus(TicketStatus.INPROGRESS);
                        break;
                    case 3:
                        ticketService.getTicketsOfStatus(TicketStatus.RESOLVED);
                        break;
                    default:
                        System.out.println("\nInvalid choice of priority. Please try again.");
                        break;

                }
                valid = true;
            } else {
                System.out.println("Strings are not allowed");

            }
        }

    }

    @Override
    public void updateTicket() {

        List<Ticket> tickets = ticketService.getAllTickets();

        Ticket update = new Ticket();

        System.out.println("********* Update Ticket *********\n\n");

        getAllTickets();

        System.out.println("Enter the ticket id of the ticket you want to update: ");
        // check if the ticket id exists
        update.setTicketId(scanner.nextLine());

        for (Ticket ticket : tickets) {
            if (ticket.getTicketId().equals(update.getTicketId())) {

                System.out.println("Enter select fields you want to update: ");
                System.out.println("1. Client Name");
                System.out.println("2. Client Contact");
                System.out.println("3. Ticket Description");
                System.out.println("4. Ticket Category");
                System.out.println("5. Ticket Priority");
                System.out.println("6. Ticket Status");
                System.out.println("7. All");

                System.out.println("Enter your choice: ");

                String choice = scanner.nextLine();

                while (!choice.matches("[0-9]+")) {
                    System.out.println("Enter a valid choice: ");
                    choice = scanner.nextLine();
                }

                int choiceInt = Integer.parseInt(choice);

                switch (choiceInt) {
                    // create a method for each case
                    case 1:
                        System.out.println("Enter new client name: ");

                        update.setClientName(scanner.nextLine());

                        ticket.setClientName(update.getClientName());

                        ticketService.updateTicket(update);
                        break;
                    case 2:
                        System.out.println("Enter new client contact: ");

                        update.setClientContact(scanner.nextLine());

                        ticket.setClientContact(update.getClientContact());

                        ticketService.updateTicket(update);
                        break;
                    case 3:
                        System.out.println("Enter new ticket description: ");
                        update.setTicketDescription(scanner.nextLine());

                        ticket.setTicketDescription(update.getTicketDescription());

                        ticketService.updateTicket(update);
                        break;
                    case 4:
                        System.out.println("************** Update Ticket Category **************\n\n");
                        int i = 0;
                        for (TicketCategory ticketCategory : TicketCategory.values()) {
                            System.out.println(++i + ". " + ticketCategory.name());
                        }

                        System.out.println("Enter new ticket category: ");

                        boolean scanForTrue = false;
                        i = 0;
                        while (scanForTrue == false && i < 3) {
                            String categoryNum = scanner.nextLine();
                            if (categoryNum.matches("[0-9]+")) {
                                update.setTicketCategory(TicketCategory.values()[Integer.parseInt(categoryNum) - 1]);
                                ++i;
                                scanForTrue = true;
                            } else {
                                System.out.println("Invalid choice of ticket category. Please try again.");

                                System.out.println("Enter new ticket category: ");
                            }
                        }

                        if (scanForTrue == true) {

                            ticket.setTicketCategory(update.getTicketCategory());
                            ticketService.updateTicket(update);

                        }

                        break;
                    case 5:
                        System.out.println("************** Update Ticket Priority **************\n\n");
                        int j = 0;
                        for (TicketPriority ticketPriority : TicketPriority.values()) {
                            System.out.println(++j + ". " + ticketPriority.name());
                        }

                        System.out.println("Enter new ticket priority: ");

                        boolean scanForTrue1 = false;
                        j = 0;

                        while (scanForTrue1 == false && j < 3) {
                            String priorityNum = scanner.nextLine();
                            if (priorityNum.matches("[0-9]+")) {
                                update.setTicketPriority(TicketPriority.values()[Integer.parseInt(priorityNum) - 1]);
                                ++j;
                                scanForTrue1 = true;
                            } else {
                                System.out.println("Invalid choice of ticket priority. Please try again.\n");
                                System.out.println("Enter new ticket priority: ");
                            }
                        }

                        if (scanForTrue1 == true) {

                            ticket.setTicketPriority(update.getTicketPriority());
                            ticketService.updateTicket(update);

                        }
                        break;
                    case 6:
                        System.out.println("************** Update Ticket Status **************\n\n");
                        int k = 0;
                        for (TicketStatus ticketStatus : TicketStatus.values()) {
                            System.out.println(++k + ". " + ticketStatus.name());
                        }

                        System.out.println("Select new ticket status: ");

                        boolean scanForTrue2 = false;
                        k = 0;

                        while (scanForTrue2 == false && k < 3) {
                            String statusNum = scanner.nextLine();
                            if (statusNum.matches("[0-9]+")) {
                                update.setTicketStatus(TicketStatus.values()[Integer.parseInt(statusNum) - 1]);
                                ++k;
                                scanForTrue2 = true;
                            } else {
                                System.out.println("Invalid choice of ticket status. Please try again.\n");
                                System.out.println("Enter new ticket status: ");
                            }
                        }

                        if (scanForTrue2 == true) {

                            ticket.setTicketStatus(update.getTicketStatus());
                            ticketService.updateTicket(update);

                        }

                        break;
                    case 7:
                        try {
                            System.out.println(
                                    "The previous ticket is going to be deleted and a new ticket will be created.");
                            System.out.println("Are you sure you want to continue? Enter (Y/N)");

                            String confirm = scanner.nextLine();

                            if (confirm.equalsIgnoreCase("Y")) {
                                // pass the index of the ticket to be deleted
                                ticketService.deleteTicket(tickets.indexOf(ticket));

                                createTicket();
                            } else if (confirm.equalsIgnoreCase("N")) {
                                System.out.println("Ticket not updated");
                            } else {
                                System.out.println("Invalid choice");
                            }
                        } catch (Exception e) {
                            // TODO: handle exception
                        }
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }

            } else {
                System.out.println("Ticket not found");
            }
        }

    }

    @Override
    public void deleteTicket() {
        try {
            List<Ticket> tickets = ticketService.getAllTickets();
            System.out.println("********* Delete Ticket *********\n\n");

            for (Ticket ticket : tickets) {

                System.out.println("****Record" + (tickets.indexOf(ticket) + 1) + "****");
                System.out.println(
                        "Ticket ID: " + ticket.getTicketId() + "\n" + "Client Name: " + ticket.getClientName() + "\n"
                                + "Contact: " + ticket.getClientContact() + "\n" + "Description: "
                                + ticket.getTicketDescription() + "\n"
                                + "Category: " + ticket.getTicketCategory() + "\n"
                                + "Priority: " + ticket.getTicketPriority() + "\n" + "Status: "
                                + ticket.getTicketStatus() + "\n");

            }

            System.out.println("Enter the ticket id of the ticket you want to delete: ");
            String ticketId = scanner.nextLine();

            for (Ticket ticket : tickets) {
                if (ticket.getTicketId().equals(ticketId)) {
                    ticketService.deleteTicket(tickets.indexOf(ticket));
                } else {
                    System.out.println("Ticket not found");
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

}