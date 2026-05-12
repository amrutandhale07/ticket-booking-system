package com.ticketbooking;

import com.ticketbooking.service.BookingService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookingService bookingService = new BookingService();

        System.out.println("==============================================");
        System.out.println("  Welcome to the Online Ticket Booking System ");
        System.out.println("==============================================");

        while (true) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Book Train Ticket");
            System.out.println("2. Book Bus Ticket");
            System.out.println("3. Book Flight Ticket");
            System.out.println("4. View All Bookings");
            System.out.println("5. Rate Our Service");
            System.out.println("6. Customer Support");
            System.out.println("7. View Average Rating");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            if (choice == 8) {
                System.out.println("Exiting... Thank you for using our system!");
                break;
            }

            switch (choice) {
                case 1:
                case 2:
                case 3:
                    bookTicket(choice, scanner, bookingService);
                    break;
                case 4:
                    bookingService.showAllBookings();
                    break;
                case 5:
                    rateService(scanner, bookingService);
                    break;
                case 6:
                    customerSupport(scanner, bookingService);
                    break;
                case 7:
                    bookingService.showAverageRating();
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        scanner.close();
    }

    private static void bookTicket(int choice, Scanner scanner, BookingService bookingService) {
        System.out.print("Enter Passenger Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Source: ");
        String source = scanner.nextLine();
        System.out.print("Enter Destination: ");
        String destination = scanner.nextLine();
        System.out.print("Enter Date (DD/MM/YYYY): ");
        String date = scanner.nextLine();
        System.out.print("Enter Price: ");
        double price = Double.parseDouble(scanner.nextLine());

        switch (choice) {
            case 1:
                System.out.print("Enter Train Number: ");
                String trainNo = scanner.nextLine();
                System.out.print("Enter PNR: ");
                String pnr = scanner.nextLine();
                System.out.print("Enter Berth Type: ");
                String berth = scanner.nextLine();
                bookingService.addTicket(new TrainTicket(name, source, destination, date, price, trainNo, pnr, berth));
                break;
            case 2:
                System.out.print("Enter Bus Operator: ");
                String operator = scanner.nextLine();
                System.out.print("Enter Seat Number: ");
                String seat = scanner.nextLine();
                System.out.print("Enter Bus Type: ");
                String busType = scanner.nextLine();
                bookingService
                        .addTicket(new BusTicket(name, source, destination, date, price, operator, seat, busType));
                break;
            case 3:
                System.out.print("Enter Flight Number: ");
                String flightNo = scanner.nextLine();
                System.out.print("Enter Airline: ");
                String airline = scanner.nextLine();
                System.out.print("Enter Class Type: ");
                String classType = scanner.nextLine();
                bookingService.addTicket(
                        new FlightTicket(name, source, destination, date, price, flightNo, airline, classType));
                break;
        }
    }

    private static void rateService(Scanner scanner, BookingService bookingService) {
        System.out.print("Enter Your Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Rating (1-5): ");
        int score = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Feedback: ");
        String feedback = scanner.nextLine();
        bookingService.addRating(new Rating(name, score, feedback));
    }

    private static void customerSupport(Scanner scanner, BookingService bookingService) {
        System.out.println("\n--- CUSTOMER SUPPORT ---");
        System.out.println("1. Raise a Support Ticket");
        System.out.println("2. View Support Tickets");
        System.out.print("Choose option: ");
        int choice = Integer.parseInt(scanner.nextLine());

        if (choice == 1) {
            System.out.print("Enter Your Name: ");
            String name = scanner.nextLine();
            System.out.print("Describe your issue: ");
            String issue = scanner.nextLine();
            bookingService.raiseSupportTicket(new SupportTicket(name, issue));
        } else if (choice == 2) {
            bookingService.showSupportTickets();
        } else {
            System.out.println("Invalid option.");
        }
    }
}
