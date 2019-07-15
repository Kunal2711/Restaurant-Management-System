package model;

import exceptions.BookingALreadyExistsException;
import exceptions.InvalidTimeException;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MakeRegularBookingWindow extends JFrame implements ActionListener{

    private JLabel nameLabel;
    private JPanel panel;
    //private JLabel typeLabel;
    private JLabel timeLabel;
    private JTextField nameField;
    private JTextField timeField;
    private JButton submit;
    private JButton home;
    private Customer c;
    private Restaurant r;
    //private Booking b;
//    private ButtonGroup group;
//    private JRadioButton new_customer;
//    private JRadioButton exisiting_customer;
    private static MakeRegularBookingWindow mb = new MakeRegularBookingWindow();



    public MakeRegularBookingWindow(){
        super("New Booking");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(20, 40, 500, 250);
        setLayout(new FlowLayout());
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//        gbc.gridx = 0;
//        gbc.gridy = 0;


        r = new Restaurant();
        //b = new Booking(r);
        c = new RegularCustomer("");


        nameField = new JTextField(20);
        nameField.addActionListener(this);
        nameLabel = new JLabel("Enter the name of the customer");

        timeField = new JTextField(3);
        timeField.addActionListener(this);
        timeLabel = new JLabel("Enter a valid time between 1300 and 2200");

        //group = new ButtonGroup();

//        typeLabel = new JLabel("Choose status of customer");
//        new_customer = new JRadioButton("New Customer");
//        new_customer.setMnemonic(KeyEvent.VK_N);
//        new_customer.setActionCommand("New Customer");
//
//        exisiting_customer = new JRadioButton("Existing Rewards Member");
//        exisiting_customer.setMnemonic(KeyEvent.VK_E);
//        exisiting_customer.setActionCommand("Existing Rewards Member");

        submit = new JButton("Submit");
        submit.setActionCommand("myButton");
        submit.addActionListener(this);

        home = new JButton("Main Menu");
        home.setActionCommand("homeBtn");
        home.addActionListener(this);

//        group.add(new_customer);
//        group.add(exisiting_customer);
//
//        new_customer.addActionListener(this);
//        exisiting_customer.addActionListener(this);

        add(nameLabel);
//        gbc.gridx = 1;
//        gbc.gridy = 1;

        add(nameField);
//        gbc.gridx = 0;
//        gbc.gridy = 2;
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//        gbc.gridwidth = 2;




//        add(typeLabel);
//        add(new_customer);
//        add(exisiting_customer);

        add(timeLabel);
//        gbc.fill = GridBagConstraints.VERTICAL;
//        gbc.gridx = -2;
//        gbc.gridy = 0;

        add(timeField);
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//        gbc.ipady = 20;
//        gbc.gridx = 0;
//        gbc.gridy = 1;

        add(submit);
//        gbc.gridx = 1;
//        gbc.gridy = 0;

        add(home);
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//        gbc.gridx = 0;
//        gbc.gridy = 2;
    }

    public Restaurant getR() {
        return r;
    }

    @Override
    public void actionPerformed(ActionEvent e)  {
        if(e.getActionCommand().equals("myButton"))
        {

           c = new RegularCustomer(nameField.getText());
           c.setName(nameField.getText());

//            if(new_customer.isSelected())
//                c = new RegularCustomer(nameField.getText());
//            else if (exisiting_customer.isSelected())
//                c = new RewardCustomer(nameField.getText());

            try {
                c.setReservationTime(Integer.parseInt(timeField.getText()));
            } catch (InvalidTimeException e1) {
                e1.printStackTrace();
            } catch (BookingALreadyExistsException e1) {
                e1.printStackTrace();
            }


            //reservations.set(Integer.parseInt(timeField.getText()), c);
            //b.MakeNewBooking(c, Integer.parseInt(timeField.getText()));
            r.getBooking().set(Integer.parseInt(timeField.getText()), c);
            r.VerifyBooking(c,Integer.parseInt(timeField.getText()));
            r.ReservationList();
            ReservationsWindow rw = new ReservationsWindow();
            rw.setVisible(true);
            mb.setVisible(false);
        }

        else if(e.getActionCommand().equals("homeBtn")){
            MainMenu ex = new MainMenu();
            ex.setVisible(true);
            mb.setVisible(false);

        }

    }

    public static void main(String[] args) {
        mb.setVisible(true);

    }

}
