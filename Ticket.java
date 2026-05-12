package com.ticketbooking.models;

public abstract class Ticket {
    private String passengerName;
    private String source;
    private String destination;
    private String date;
    private double price;

    public Ticket(String passengerName, String source, String destination, String date, double price) {
        this.passengerName = passengerName;
        this.source = source;
        this.destination = destination;
        this.date = date;
        this.price = price;
    }

    public String getPassengerName() { return passengerName; }
    public String getSource() { return source; }
    public String getDestination() { return destination; }
    public String getDate() { return date; }
    public double getPrice() { return price; }

    public abstract void displayTicketDetails();
}
