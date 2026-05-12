package com.ticketbooking.models;

public class SupportTicket {
    private static int idCounter = 1000;
    private int ticketId;
    private String userName;
    private String issue;
    private String status;

    public SupportTicket(String userName, String issue) {
        this.ticketId = idCounter++;
        this.userName = userName;
        this.issue = issue;
        this.status = "Open";
    }

    public int getTicketId() { return ticketId; }
    public String getStatus() { return status; }

    @Override
    public String toString() {
        return "Ticket ID: " + ticketId + " | User: " + userName + " | Issue: " + issue + " | Status: " + status;
    }
}
