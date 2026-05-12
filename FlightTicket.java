package com.ticketbooking.models;

public class FlightTicket extends Ticket {
    private String flightNumber;
    private String airline;
    private String classType;

    public FlightTicket(String passengerName, String source, String destination, String date, double price, String flightNumber, String airline, String classType) {
        super(passengerName, source, destination, date, price);
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.classType = classType;
    }

    @Override
    public void displayTicketDetails() {
        System.out.println("--- Flight Ticket ---");
        System.out.println("Passenger: " + getPassengerName());
        System.out.println("From: " + getSource() + " To: " + getDestination());
        System.out.println("Date: " + getDate());
        System.out.println("Price: $" + getPrice());
        System.out.println("Flight No: " + flightNumber);
        System.out.println("Airline: " + airline);
        System.out.println("Class: " + classType);
        System.out.println("---------------------");
    }
}
