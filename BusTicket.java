package com.ticketbooking.models;

public class BusTicket extends Ticket {
    private String operator;
    private String seatNumber;
    private String busType;

    public BusTicket(String passengerName, String source, String destination, String date, double price, String operator, String seatNumber, String busType) {
        super(passengerName, source, destination, date, price);
        this.operator = operator;
        this.seatNumber = seatNumber;
        this.busType = busType;
    }

    @Override
    public void displayTicketDetails() {
        System.out.println("--- Bus Ticket ---");
        System.out.println("Passenger: " + getPassengerName());
        System.out.println("From: " + getSource() + " To: " + getDestination());
        System.out.println("Date: " + getDate());
        System.out.println("Price: $" + getPrice());
        System.out.println("Operator: " + operator);
        System.out.println("Seat No: " + seatNumber);
        System.out.println("Bus Type: " + busType);
        System.out.println("------------------");
    }
}
