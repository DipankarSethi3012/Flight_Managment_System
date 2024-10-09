package org.example;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class Flightmanagment {
    private List<Flight> flightList ;
    private List<Airport> airportList;
    private List<Layover> layoverList;

    Flightmanagment(){
        flightList = new ArrayList<>();
        airportList = new ArrayList<>();
        layoverList = new ArrayList<>();
    }

    public void addFlight() {
        System.out.println("Enter data for adding a new flight-------------");
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter flight Id:");
        int flight_id = sc.nextInt();

        // Consume the leftover newline from nextInt()
        sc.nextLine();

        System.out.println("Enter flight name:");
        String flight_name = sc.nextLine();

        System.out.println("Enter the source of flight:");
        String flight_source = sc.nextLine();

        System.out.println("Enter destination of flight:");
        String flight_destination = sc.nextLine();

        System.out.println("Enter total number of seats in flight:");
        int totalSeats = sc.nextInt();

        // Assuming initial booked seats are 0
        Flight flight = new Flight(flight_id, flight_name, flight_source, flight_destination, totalSeats);

        String sql = "INSERT INTO flight (flight_id, flight_name, flight_source, flight_destination, flight_total_seats, flight_booked_seats) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            Connection connection = ConnectionDetails.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, flight.getFlightId());
            preparedStatement.setString(2, flight.getFlightName());
            preparedStatement.setString(3, flight.getSource());
            preparedStatement.setString(4, flight.getDestination());
            preparedStatement.setInt(5, flight.getTotalSeats());
            preparedStatement.setInt(6, flight.getBookedSeats());  // Assuming bookedSeats is initially 0

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        flightList.add(flight);
        System.out.println("Flight added to list successfully");
        System.out.println("Flight entry created in database successfully");
    }



    public void addAirport() {
        System.out.println("Entering data for adding an airport into database---------");
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter id of Airport:-");
        int airport_id = sc.nextInt();

        System.out.println("Enter airport name:-");
        String airport_name = sc.nextLine();

        System.out.println("Enter city in which airport located:-");
        String airport_city = sc.nextLine();

        System.out.println("Enter country in  which airport is located:-");
        String airport_country = sc.nextLine();


        Airport airport = new Airport(airport_id, airport_name, airport_city, airport_country);
        airportList.add(airport);
        System.out.println("Airport added in list successfully");

        String sql = "insert into airport (airport_id, airport_name, airport_city, airport_country) values(?, ?, ?, ?)";
        try {
            Connection connection = ConnectionDetails.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, airport.getAirportId());
            preparedStatement.setString(2, airport.getAirportName());
            preparedStatement.setString(3, airport.getCity());
            preparedStatement.setString(4, airport.getCountry());
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Airport entry created in database successfully");
    }

    public void addLayover() {
        System.out.println("Entering data for adding a layover-----");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter layover id:");
        int layover_id = sc.nextInt();

        System.out.println("Enter layover time");
        int layover_time = sc.nextInt();

        System.out.println("Enter flightId for layover");
        int flight_id = sc.nextInt();

        System.out.println("Enter airport id for layover");
        int airport_id = sc.nextInt();

        Layover layover = new Layover(layover_id, layover_time, flight_id, airport_id);
        System.out.println("Layover added in list successfully");

        String sql = "insert into layover (layover-id, layover_name, flight_id, airport_id) values(?, ?, ?, ?)";

        try {
            Connection connection = ConnectionDetails.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, layover.getLayoverId());
            preparedStatement.setInt(2, layover.getLayoverTime());
            preparedStatement.setInt(3, layover.getFlightId());
            preparedStatement.setInt(4, layover.getAirportId());

        } catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("Layover details added in db successfully");

    }

    public  boolean bookSeat(int flight_id) {
        for(Flight flight : flightList) {
            if(flight.getFlightId() == flight_id && flight.bookSeat()) {
                updateFlight(flight);
                return true;
            }
        }

        return false;
    }

    public void  updateFlight(Flight flight) {
        String sql = "update flight set flight_booked_seats = ? where flight_id = ?";

        try {
            Connection connection = ConnectionDetails.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, flight.getBookedSeats());
            preparedStatement.setInt(2, flight.getFlightId());

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Flight has been update successfully");
    }

    public List<Flight> getAllFlights() {
        return flightList;
    }

    public List<Airport> getAllAirport(){
        return airportList;
    }

    public List<Layover> getAllLayover() {
        return layoverList;
    }

    public void displayAllFlights() {
        System.out.println("All Flights:");
        for (Flight flight : flightList) {
            System.out.println("Flight ID: " + flight.getFlightId() + ", Name: " + flight.getFlightName() +
                    ", Source: " + flight.getSource() + ", Destination: " + flight.getDestination() +
                    ", Total Seats: " + flight.getTotalSeats() + ", Booked Seats: " + flight.getBookedSeats());
        }
    }

    public void displayAllAirports() {
        System.out.println("All Airports:");
        for (Airport airport : airportList) {
            System.out.println("Airport ID: " + airport.getAirportId() + ", Name: " + airport.getAirportName() +
                    ", City: " + airport.getCity() + ", Country: " + airport.getCountry());
        }
    }

    public void displayAllLayovers() {
        System.out.println("All Layovers:");
        for (Layover layover : layoverList) {
            System.out.println("Layover ID: " + layover.getLayoverId() + ", Flight ID: " + layover.getFlightId() +
                    ", Airport ID: " + layover.getAirportId() + ", Layover Time: " + layover.getLayoverTime() + " hours");
        }
    }

}
