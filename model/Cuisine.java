package model;

import java.util.ArrayList;

public class Cuisine {
    String cName;
    ArrayList<Customer> customers;

    public Cuisine(String cName){
        this.cName = cName;
    }

    public void addCustomer(Customer c){
        if(!customers.contains(c)){
            customers.add(c);
        }
    }
}
