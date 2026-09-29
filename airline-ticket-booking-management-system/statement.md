# Project Statement

## Project Title
Airline Ticket Booking Management System

## Problem Statement
Manual airline ticket booking can require repeated checking of flight details, passenger information, seat availability, and booking status. The purpose of this project is to implement a small command-line system that organizes these operations in one Java application.

## Scope
The project covers flight listing, route search, passenger entry, ticket booking, booking history, ticket cancellation, seat updates, local file persistence, and confirmation notification through a background thread.

The project is intentionally limited to a terminal-based demonstration. It does not process real payments, connect to a live airline API, or issue legally valid airline tickets.

## Target Users
- Students learning Java application development
- Small demonstration users testing a booking workflow
- Faculty/evaluators reviewing Java OOP, collections, exceptions, I/O and multithreading concepts

## High-Level Features
1. Flight management and display
2. Flight search
3. Passenger and ticket booking
4. Booking history
5. Ticket cancellation
6. Persistent local data storage
7. Input validation and error handling
8. Asynchronous confirmation notification

## Major Functional Modules
### 1. Flight Management
Displays flights, route details, fares and available seats.

### 2. Booking Management
Creates a booking, generates a booking ID and reduces available seats.

### 3. Cancellation and History
Displays bookings and cancels an active booking while releasing its seat.

## Non-Functional Requirements
- **Usability:** menu-driven terminal interface with simple prompts.
- **Reliability:** invalid input is handled without terminating the application.
- **Maintainability:** functionality is separated into multiple Java classes.
- **Resource efficiency:** uses in-memory collections and local file storage; no external server is required.
- **Error handling:** custom validation exception and try-catch blocks are used.
- **Portability:** runs on systems with Java JDK 17+.

## Constraints
- Local demonstration data only.
- No real airline inventory or payment gateway.
- No graphical interface is required.
