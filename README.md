# Airline Management System

## Project Overview

The Airline Management System is a Java-based desktop application developed to manage basic airline operations through a graphical user interface.

The system provides functionality for user login, customer management, flight information, ticket booking, journey details, cancellation, and boarding pass generation.

The project is developed using Java Swing for the graphical user interface and JDBC for communication with a MySQL database.

---

## Objectives

The main objectives of this project are:

- To develop a simple airline management application using Java.
- To provide a graphical interface for airline-related operations.
- To implement object-oriented programming concepts.
- To connect a Java application with a MySQL database using JDBC.
- To manage flight and passenger information.
- To provide ticket booking and cancellation functionality.
- To generate and display boarding pass information.

---

## Technologies Used

- **Programming Language:** Java
- **GUI:** Java Swing
- **Database:** MySQL
- **Database Connectivity:** JDBC
- **IDE:** Apache NetBeans
- **JDK:** JDK 17 or later
- **Version Control:** Git and GitHub

---

## Features

### 1. User Login

The system provides a login screen where the user enters a username and password.

The credentials are verified against the `login` table in the MySQL database.

### 2. Customer Management

The system allows customer/passenger information to be entered and managed.

### 3. Flight Information

The application provides flight-related information such as flight number, source, destination and other available details.

### 4. Flight Booking

Users can select a flight and enter the required passenger and journey information to book a ticket.

### 5. Journey Details

The system stores and displays journey-related information for booked passengers.

### 6. Ticket Cancellation

The application provides functionality to cancel a previously booked ticket.

### 7. Boarding Pass

The system can display boarding pass information for a booked passenger.

---

## Project Structure

```text
Airline Management System
│
├── src/
│   └── airlinemanagementsystem/
│       ├── AddCustomer.java
│       ├── AirlineManagementSystem.java
│       ├── BoardingPass.java
│       ├── BookFlight.java
│       ├── Cancel.java
│       ├── Conn.java
│       ├── FlightInfo.java
│       ├── Home.java
│       ├── JourneyDetails.java
│       ├── Login.java
│       └── ResultSetTableModel.java
│
├── sql/
│   └── airlinemanagementsystem.sql
│
├── lib/
│   └── mysql-connector-j.jar
│
├── screenshots/
│
├── docs/
│
├── README.md
├── TESTING.md
└── statement.md
