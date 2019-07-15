package test;

import model.Customer;
import model.RegularCustomer;
import model.Restaurant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestRestaurant {
    Restaurant piazza;
    Customer kun;

    @BeforeEach

    public void setUp(){
        piazza = new Restaurant();
        kun = new RegularCustomer("Kunal");
    }


    @Test
    public void testMakeBookingAtAvailableTime() throws IOException, ClassNotFoundException {
     piazza.MakeNewBooking(kun, 18);
     assertTrue(piazza.VerifyBooking(kun,18));
    }

    @Test
    public void testMakeMultipleBookings() throws IOException, ClassNotFoundException {
        piazza.MakeNewBooking(kun, 14);
        assertTrue(piazza.VerifyBooking(kun, 14));

        Customer jaba = new RegularCustomer("Jaba The Hut");
        piazza.MakeNewBooking(jaba, 17);
        assertTrue(piazza.VerifyBooking(jaba, 17));

        Customer han = new RegularCustomer("Han Solo");
        piazza.MakeNewBooking(han, 21);
        assertTrue(piazza.VerifyBooking(han,21));
    }



    }


