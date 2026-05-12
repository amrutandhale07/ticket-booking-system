package com.ticketbooking.service;

import com.ticketbooking.models.Ticket;
import com.ticketbooking.models.Rating;
import com.ticketbooking.models.SupportTicket;

import java.util.ArrayList;
import java.util.List;

public class BookingService {
    private List<Ticket> bookings;
    private List<Rating> ratings;
    private List<SupportTicket> supportTickets;

    public BookingService() {
        this.bookings = new ArrayList<>();
        this.ratings = new ArrayList<>();
        this.supportTickets = new ArrayList<>();
    }

    public void addTicket(Ticket ticket) {
        bookings.add(ticket);
        System.out.println("\nTicket booked successfully!");
    }

    public void showAllBookings() {
        if (bookings.isEmpty()) {
            System.out.println("\nNo bookings found.");
            return;
        }
        System.out.println("\n--- ALL BOOKINGS ---");
        for (Ticket ticket : bookings) {
            ticket.displayTicketDetails();
        }
    }

    public void addRating(Rating rating) {
        ratings.add(rating);
        System.out.println("\nThank you for your rating!");
    }

    public void showAverageRating() {
        if (ratings.isEmpty()) {
            System.out.println("\nNo ratings yet.");
            return;
        }
        double sum = 0;
        for (Rating r : ratings) {
            sum += r.getScore();
        }
        System.out.printf("\nAverage Customer Rating: %.2f/5 (Based on %d reviews)\n", (sum / ratings.size()), ratings.size());
    }

    public void raiseSupportTicket(SupportTicket ticket) {
        supportTickets.add(ticket);
        System.out.println("\nSupport ticket raised! Ticket ID: " + ticket.getTicketId());
    }

    public void showSupportTickets() {
        if (supportTickets.isEmpty()) {
            System.out.println("\nNo support tickets found.");
            return;
        }
        System.out.println("\n--- CUSTOMER SUPPORT TICKETS ---");
        for (SupportTicket t : supportTickets) {
            System.out.println(t);
        }
    }
}
