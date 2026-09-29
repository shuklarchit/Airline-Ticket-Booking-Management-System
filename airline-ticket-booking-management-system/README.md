# Airline Ticket Booking Management System

A simple command-line Java project for the VITyarthi Build Your Own Project evaluation. The system manages flights, searches routes, books tickets, stores booking history, and supports cancellation.

## Features

1. View available flights
2. Search flights by source and destination
3. Book an airline ticket
4. View booking history
5. Cancel a booking and release the seat
6. Save and load data using Java I/O serialization
7. Background booking-confirmation notification using a Java thread
8. Input validation and custom exception handling

## Course Concepts Demonstrated

The implementation intentionally uses concepts from the Programming in Java syllabus:

- Classes and objects
- Constructors
- Encapsulation using private fields and getters
- Inheritance (`Passenger` extends `Person`)
- Method overriding (`toString()`)
- ArrayList / Java Collections Framework
- Exception handling (`try-catch`) and a user-defined exception
- Multithreading using `Runnable` and `Thread`
- File I/O using `ObjectInputStream` and `ObjectOutputStream`
- Loops, conditionals and switch-case
- Packages and modular class structure

The syllabus explicitly covers OOP, exception handling, multithreading, collections, I/O streams, and database applications. This project uses the first four areas directly while keeping the application simple and terminal-executable. fileciteturn0file0L44-L75

## Requirements

- Java JDK 17 or later
- Terminal / Command Prompt
- No external library is required

## Folder Structure

```text
airline-ticket-booking-management-system/
├── README.md
├── statement.md
├── run.bat
├── run.sh
├── data/
│   └── airline_data.dat        # created automatically after first save
├── docs/
│   └── project_report.pdf
├── screenshots/
├── src/
│   └── airline/
│       ├── AirlineSystem.java
│       ├── Booking.java
│       ├── FileManager.java
│       ├── Flight.java
│       ├── InputValidator.java
│       ├── Main.java
│       ├── NotificationService.java
│       ├── Passenger.java
│       ├── Person.java
│       └── ValidationException.java
```

## How to Run

### Windows

Open Command Prompt in the project root and run:

```bat
run.bat
```

Or manually:

```bat
if not exist out mkdir out
javac -d out src\airline\*.java
java -cp out airline.Main
```

### Linux / macOS

```bash
chmod +x run.sh
./run.sh
```

Or manually:

```bash
mkdir -p out
javac -d out src/airline/*.java
java -cp out airline.Main
```

## Data Storage

The project uses Java object serialization to save flights and bookings to `data/airline_data.dat`. The file is generated automatically when a booking is made or when the application exits.

## Testing

Test the following cases from the menu:

- View all flights
- Search an existing route
- Search a route that does not exist
- Book a valid flight
- Try booking with an empty passenger name
- View booking history
- Cancel a valid booking
- Try cancelling an invalid booking ID
- Restart the program and verify that saved booking data is loaded

## Important Submission Notes

- Set the GitHub repository to **Public** before submitting.
- Submit only the repository root URL, not a `/tree/main/` or `/blob/` URL.
- Keep `README.md` at the repository root.
- Keep `statement.md` at the repository root.
- Upload the generated project report PDF separately on VITyarthi.

The VITyarthi instructions require at least three functional modules, at least four non-functional requirements, a clear workflow, 5–10 meaningful classes/files for coding projects, and documentation/design artefacts. citeturn0view0
