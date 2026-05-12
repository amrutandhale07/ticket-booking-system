# Implementation Plan - Online Ticket Booking System Completion

This plan outlines the steps to complete the Online Ticket Booking System, incorporating the requested features: viewing booked tickets, customer rating system, and customer support.

## 1. Workspace Initialization
- Recreate the existing project structure in the `/Users/amrutandhale/Downloads/Java Project` directory.
- Files to recreate:
    - `com.ticketbooking.models.Ticket`
    - `com.ticketbooking.models.TrainTicket`
    - `com.ticketbooking.models.BusTicket`
    - `com.ticketbooking.models.FlightTicket`
    - `com.ticketbooking.service.BookingService`
    - `com.ticketbooking.Main`

## 2. Customer Rating System
- Create `com.ticketbooking.models.Rating` to store user feedback and numerical ratings (1-5).
- Enhance `BookingService` with:
    - `List<Rating> ratings`
    - `addRating(Rating rating)`
    - `showAverageRating()`
- Update `Main.java` to add a menu option for "Rate Our Service".

## 3. Customer Support
- Create `com.ticketbooking.models.SupportTicket` to manage user queries/issues.
- Enhance `BookingService` with:
    - `List<SupportTicket> supportTickets`
    - `raiseSupportTicket(SupportTicket ticket)`
    - `showSupportStatus()`
- Update `Main.java` to add a menu option for "Customer Support".

## 4. Integration & Testing
- Ensure all components are modular and interact correctly.
- Verify that "View All Bookings" shows details from all transport modes.
- Test the new rating and support flows.
