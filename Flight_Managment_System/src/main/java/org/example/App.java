package org.example;

import java.util.Scanner;
import java.util.SortedMap;

/**
 * Hello world!
 *
 */
public class App 
{
    public static <List> void main(String[] args )
    {

        System.out.println( "Welcome to Flight Management system" );
        Flightmanagment flightmanagment = new Flightmanagment();
        Scanner sc = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {
            System.out.println("\n Project Starts: \n");
            System.out.println("1-> Add a flight");
            System.out.println("2-> Add Airport");
            System.out.println("3-> Add Layover");
            System.out.println("4-> Book a seat");
            System.out.println("5-> Display ALL flights");
            System.out.println("6-> Display All Airports");
            System.out.println("7-> Display All LayOvers");
            System.out.println("(8-> exit from the project");
            System.out.println();
            System.out.println("Enter choice carefully :-");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Entering to add flight");
                    flightmanagment.addFlight();
                    break;
                case 2:
                    System.out.println("Entering to add airport");
                    flightmanagment.addAirport();
                    break;
                case 3:
                    System.out.println("Entering to layover add");
                    flightmanagment.addLayover();
                    break;
                case 4:
                    System.out.println("Booking a seat");
                    System.out.println("Enter flightId to book a seat");
                    int flight_id = sc.nextInt();
                    if(flightmanagment.bookSeat(flight_id)){
                        System.out.println("Congrats! booking confirmed");
                    } else{
                        System.out.println("Sorry! no seats available");
                    }
                    break;
                case 5:
                    System.out.println("Displaying All flights");
                    flightmanagment.displayAllFlights();
                    break;
                case 6:
                    System.out.println("Displaying All airports");
                    flightmanagment.displayAllAirports();
                    break;
                case 7:
                    System.out.println("Displaying all Layovers");
                    flightmanagment.displayAllLayovers();
                    break;
                case 8:
                    exit = true;
                    System.out.println("Thanks! for coming");
                    System.out.println("Exited from the project");
                    break;
                default:
                    System.out.println("Invalid test case");
            }

        }
        sc.close();
    }
}
