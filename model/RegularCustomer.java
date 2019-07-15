package model;

public class RegularCustomer extends Customer {

    public RegularCustomer(String name){
        super(name);
    }

    @Override
    public int confirmBooking(){
        System.out.println("Confirmed that" + name + "has been booked at " + reservationTime);
        return reservationTime;
    }
}
