# TravelPro | Online Ticket Booking System

TravelPro is a comprehensive multi-mode transport booking system that allows users to book Train, Bus, and Flight tickets through both a robust **Java Backend** and a modern **Web Application**.

## 🚀 Features

### Core Booking
- **Multi-Mode Support**: Specialized booking forms for Trains, Buses, and Flights.
- **Dynamic Fields**: Specific data collection for each mode (PNR for trains, Airline for flights, Seat numbers for buses).
- **Payment Integration**: Support for multiple payment methods including Credit Card, UPI, Net Banking, and Wallets.

### User Experience
- **Modern Web UI**: A sleek, minimalist SaaS-style interface built with HTML, CSS, and Vanilla JS.
- **Dark/Light Mode**: Seamless theme switching with persistent user preference.
- **Responsive Design**: Optimized for both desktop and mobile viewing.

### Support & Feedback
- **Customer Rating System**: Real-time feedback collection with automated average rating calculation.
- **Support Ticket Portal**: Issue tracking system with unique Ticket IDs and status monitoring.

---

## 🛠️ Tech Stack

### Backend (Java)
- **Language**: Java 11+
- **Architecture**: Modular OOP design with Models and Services.
- **Persistence**: Runtime memory management.

### Frontend (Web)
- **Structure**: HTML5 Semantic markup.
- **Styling**: Modern CSS3 with Variables and Transitions.
- **Logic**: Vanilla JavaScript.
- **Persistence**: Browser LocalStorage.

---

## 📂 Project Structure

```text
Java Project/
├── src/com/ticketbooking/      # Java Source Code
│   ├── Main.java               # CLI Entry Point
│   ├── models/                 # Data Models (Ticket, Rating, etc.)
│   └── service/                # Business Logic (BookingService)
├── web-app/                    # Web Application
│   ├── index.html              # UI Structure
│   ├── style.css               # Design System
│   ├── script.js               # Frontend Logic
│   └── assets/                 # Custom Imagery
└── bin/                        # Compiled Java Classes
```

---

## 🏃 How to Run

### 1. Web Application (Recommended)
Simply open the `index.html` file in your favorite browser.
```bash
# On MacOS
open web-app/index.html
```

### 2. Java CLI Application
Compile and run the Java project from your terminal.
```bash
# Compile
javac -d bin src/com/ticketbooking/models/*.java src/com/ticketbooking/service/*.java src/com/ticketbooking/Main.java

# Run
java -cp bin com.ticketbooking.Main
```

---

## 🛡️ Support
Need help? Use the **Customer Support** section in either the Web or Java interface to raise a ticket. Our system will assign you a unique ID to track your request.

---
*Built with excellence for modern travelers.*
