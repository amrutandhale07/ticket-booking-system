package com.ticketbooking.models;

public class TrainTicket extends Ticket {
    private String trainNumber;
    private String pnr;
    private String berthType;

    public TrainTicket(String passengerName, String source, String destination, String date, double price, String trainNumber, String pnr, String berthType) {
        super(passengerName, source, destination, date, price);
        this.trainNumber = trainNumber;
        this.pnr = pnr;
        this.berthType = berthType;
    }

    @Override
    public void displayTicketDetails() {
        System.out.println("--- Train Ticket ---");
        System.out.println("Passenger: " + getPassengerName());
        System.out.println("From: " + getSource() + " To: " + getDestination());
        System.out.println("Date: " + getDate());
        System.out.println("Price: $" + getPrice());
        System.out.println("Train No: " + trainNumber);
        System.out.println("PNR: " + pnr);
        System.out.println("Berth: " + berthType);
        System.out.println("--------------------");
    }
}
