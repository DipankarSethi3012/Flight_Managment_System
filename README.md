**Flight Management System ✈️**
A Java-based application that efficiently manages flight operations, including flight scheduling, airport management, layovers, and seat booking, integrated with a MySQL database.

**Table of Contents**
Introduction
Features
Technologies Used
Database Schema
Installation
Usage
Future Enhancements
Contributing
License

**Introduction**
The Flight Management System allows users to manage flights, airports, layovers, and seat bookings. It integrates a Java application with a MySQL database to provide a reliable system for flight scheduling and seat management. By implementing prepared statements, the project ensures secure database interaction and real-time seat updates, preventing overbooking.

**Introduction**
Flight Management: Add flights with key details like flight name, source, destination, total seats, and available seats.
Airport Management: Manage airports by storing airport details (name, city, country) and integrating them with flight data.
Layover Management: Track layovers by linking flights with specific airports and layover durations.
Seat Booking: Real-time seat booking system that automatically updates seat availability in the database.
Secure Database Access: Uses prepared statements to prevent SQL injection and ensure secure data handling.

**Technologies Used**
Java: Core logic, object-oriented programming, and JDBC for database connectivity.
MySQL: Database management for storing flight, airport, and layover information.
JDBC: For communicating with the MySQL database.
Prepared Statements: Secure database operations to prevent SQL injection.

**Database Schema**

flight Table
CREATE TABLE flight (
    flight_id INT PRIMARY KEY,
    flight_name VARCHAR(50),
    flight_source VARCHAR(100),
    flight_destination VARCHAR(100),
    flight_total_seats INT,
    flight_booked_seats INT
);

airport Table
CREATE TABLE airport (
    airport_id INT PRIMARY KEY,
    airport_name VARCHAR(100),
    airport_city VARCHAR(100),
    airport_country VARCHAR(100)
);

layover Table
CREATE TABLE layover (
    layover_id INT PRIMARY KEY,
    layover_time INT,
    flight_id INT,
    airport_id INT,
    FOREIGN KEY (flight_id) REFERENCES flight(flight_id),
    FOREIGN KEY (airport_id) REFERENCES airport(airport_id)
);

**Installation**
Prerequisites
Java Development Kit (JDK): Download JDK
MySQL: Download MySQL

**Steps**
Clone the repository:
git clone (https://github.com/DipankarSethi3012/Flight_Managment_System.git)
Import the project into your preferred IDE (e.g., IntelliJ, Eclipse).

**Set up the MySQL database**:
Create the database and tables using the schema provided above.
Update the database connection details in the ConnectionDetails class.
Compile and run the project from your IDE.

**Usage**
Add a Flight: Enter flight details (ID, name, source, destination, total seats) via the command-line interface.
Add an Airport: Enter airport details (ID, name, city, country) to link flights and airports.
Add a Layover: Add a layover by specifying flight ID, airport ID, and layover time.
Book a Seat: Use the seat booking functionality to book a seat on a specific flight, with automatic updates to the available seats in the database.
Check Flight Availability: Verify if seats are available for a particular flight.

**Future Enhancements**
Add flight scheduling features.
Implement seat cancellation and refund functionality.
Develop a GUI for a more user-friendly interface.
Introduce search functionality for flights by source, destination, or date.
Integrate with external APIs for real-time flight tracking.

**Contributing**
Contributions are welcome! Feel free to submit a pull request or open an issue if you find any bugs or have suggestions for improvements.

**Fork the repository**.
Create a new branch (git checkout -b feature-branch).
Commit your changes (git commit -m 'Add some feature').
Push to the branch (git push origin feature-branch).
Open a pull request.

**License**
This project is licensed under the MIT License. See the LICENSE file for details.
