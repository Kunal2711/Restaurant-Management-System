package model;

import exceptions.BookingALreadyExistsException;
import exceptions.InvalidTimeException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Restaurant implements Loadable, Saveable {

    final Booking booking = new Booking(this);
    protected int numCustomers;

    Customer c1 = new RegularCustomer("kob");
    Customer c2 = new RegularCustomer("nob");

    Scanner sc;

    public Restaurant() {
        booking.setMaxTime(22);
        booking.setReservations(new ArrayList<>());
        for (int i = 0; i <= booking.getMaxTime(); i++) {
            booking.getReservations().add(i, null);
        }
        booking.setReso(new HashMap<>());
        numCustomers = 0;
    }


    // EFFECTS: prints out all the bookings. If the time has not been booked, prints "available"
    public void ReservationList() {
        for (int i = 13; i < booking.getReservations().size(); i++) {
            Customer c = booking.getReservations().get(i);
            if (c != null) {
                System.out.println(i + "hrs: " + c.printName());
            } else {
                System.out.println(i + "hrs: " + "available ");
            }
        }
    }

    public String getReservationList(){
        String combine =  "";
        for (int i = 13; i < booking.getReservations().size(); i++) {
            Customer c = booking.getReservations().get(i);
            if (c != null) {
                combine = (i + "hrs: " + c.printName()).toString();
            } else {
                combine = (i + "hrs: " + "available ".toString());
            }
        }
        return combine;
    }

    public ArrayList<Customer> getBooking(){
        return booking.reservations;
    }

    public int getNumberOfCustmers() {
        return numCustomers;
    }

    public void addCuisine(Cuisine cn) {
        if (!booking.getCuisines().contains(cn)) {
            booking.getCuisines().add(cn);
        }
    }



    // MODIFIES: this and RegularCustomer
    // EFFECTS:  books the customer into the requested timeslot if it is a valid timeslot,
    // and let's the RegularCustomer know the booking time.
    public void MakeNewBooking(Customer c, int reservationTime){



        //c.ConfirmBooking();
        //save();
        //booking.MakeNewBooking(c, reservationTime);
        booking.info();
        numCustomers++;
        System.out.println("There are " + numCustomers + " customers in the list");
    }

    //EFFECTS: returns true if the customer is found at the booking time.
    public boolean VerifyBooking (Customer c, int reservationTime){
        return booking.VerifyBooking(c, reservationTime);
    }


    // EFFECTS:  Gives the option to either cancel a boking or change the time of booking
    public void ChangeBooking (Customer c, int reservationTime) throws InvalidTimeException, BookingALreadyExistsException {

        booking.ChangeBooking(c, reservationTime);
        numCustomers--;
        System.out.println("There are " + numCustomers + " customers in the list");

    }


    // MODIFIES: this and RegularCustomer
    // EFFECTS:  cancels the customer booked in the bookings.
    public void CancelBooking (Customer c){
        // System.out.println("There are now " " customers in the list");
        booking.CancelBooking(c);
    }

    // MODIFIES: this and RegularCustomer
    // EFFECTS:  changes the customer booked in the bookings, and let's the RegularCustomer know the new booking time.
    public void ChangeTime (Customer customer, int newTime){

        booking.ChangeTime(customer, newTime);
    }

    public void save () throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("inputfile.txt"));

        PrintWriter writer = new PrintWriter("outputfile.txt", "UTF-8");

        lines.add("RegularCustomer time");

        for (String line : lines) {
            ArrayList<String> partsOfLine = splitOnSpace(line);
            System.out.print("Name: " + partsOfLine.get(0) + " ");
            System.out.println("Time: " + partsOfLine.get(1));
            writer.println(line);
        }

        writer.close();
    }

    public void s2 () throws IOException {
        FileOutputStream saveFile = new FileOutputStream("inputfile.txt");
        ObjectOutputStream save = new ObjectOutputStream(saveFile);
        save.writeObject(c1);
        save.writeObject(c2);
        save.close();
    }

    public static ArrayList<String> splitOnSpace (String line){
        String[] splits = line.split(" ");
        return new ArrayList<>(Arrays.asList(splits));
    }

    @Override
    public void load () throws IOException, ClassNotFoundException {
        FileInputStream saveFile = new FileInputStream("outputfile.txt");
        ObjectInputStream save = new ObjectInputStream(saveFile);
        booking.setReservations((ArrayList) save.readObject());
        save.close();
    }
}

