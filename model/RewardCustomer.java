package model;

public class RewardCustomer extends Customer{

    protected int balance;
    protected int rewardPoints;

    protected int RewardPerBooking = 100;    // points earned for each cent charged to card


    public RewardCustomer(String name){
        super(name);
    }

    // REQUIRES: initialBalance >= 0
    // EFFECTS: constructs reward card with zero reward points
    public void RewardsCard(int initialBalance) {
        balance = initialBalance;
        rewardPoints = 0;
    }

    // MODIFIES: this
    // EFFECTS: Adds Rewards Per Booking to rewardPoints
    public int makeBooking() {
            return rewardPoints += RewardPerBooking;
        }

    @Override
    public int confirmBooking(){
        System.out.println("Confirmed that" + name + "has been booked at " + reservationTime);
        System.out.println("New Reward Balance is " + makeBooking());
        return reservationTime;
    }

}
