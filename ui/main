package ui;

import exceptions.BookingALreadyExistsException;
import exceptions.InvalidTimeException;
import model.Customer;
import model.ReadWebPageEx;
import model.RegularCustomer;
import model.Restaurant;


import java.io.IOException;
import java.util.Scanner;

public class main {


    public static void main(String[] args) throws IOException, ClassNotFoundException, InvalidTimeException, BookingALreadyExistsException {
        boolean keepGoing = true;
        int command;


        System.out.println("Welcome to The Pi(a)zza Restaurant");

        Restaurant piazza = new Restaurant();
        String name;
        Customer c = new RegularCustomer("");

        while (keepGoing) {
            displayMenu();
            Scanner sc = new Scanner(System.in);
            command = sc.nextInt();

            if (command == 1)
                piazza.MakeNewBooking(c, 1);
            else if (command==(2))
                piazza.ChangeBooking(c, 2);
            else if (command==3) {
                keepGoing = false;
                System.out.println("Here is the final Reservation List");
                piazza.ReservationList();
            }
            else
                System.out.println("Selection not valid");
        }
        System.out.println("Goodbye!");
        ReadWebPageEx.main(null);
    }


    public static void displayMenu() {
        System.out.println("Type 1 to make a new reservation and 2 and change an existing reservation or 3 to quit");
    }
}



