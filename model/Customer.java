package model;

import exceptions.BookingALreadyExistsException;
import exceptions.InvalidTimeException;

import java.util.Map;
import java.util.Objects;

public abstract class Customer {
    protected String name;
    protected int reservationTime;

    public Customer(String name) {
        this.name = name;
        this.reservationTime = 0;
    }

    public String printName(){
        return name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return reservationTime == customer.reservationTime;
    }

    @Override
    public int hashCode() {

        return Objects.hash(reservationTime);
    }

    public abstract int confirmBooking();


    // Getters
    public String getName(){
        return name;
    }

    public int getReservationTime(){
        return reservationTime;
    }

    // Setters
    public void setName(String custname){
        name = custname;
    }

    public void setReservationTime(int time) throws InvalidTimeException, BookingALreadyExistsException {
        if(time > 22 || time < 13)
            throw new InvalidTimeException();
        if(reservationTime == 1){
            throw new BookingALreadyExistsException();
        }
        reservationTime = time;
    }
}
