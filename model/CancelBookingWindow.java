package model;

import exceptions.BookingALreadyExistsException;
import exceptions.InvalidTimeException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class CancelBookingWindow extends JFrame implements ActionListener{
    private JTextField nameField;
    private JLabel nameLabel;
    private JLabel timeLabel;
    private JTextField timeField;
    private JButton submit;
    private Customer c;
    private JTextArea times;
    private Restaurant r;
    private static CancelBookingWindow ex = new CancelBookingWindow();

    public CancelBookingWindow(){
        super("Cancel Booking");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(20, 40, 500, 250);
        // setPreferredSize(new Dimension(500, 250));
        setLayout(new FlowLayout());
        r = new Restaurant();


        nameField = new JTextField(20);
        nameField.addActionListener(this);
        nameLabel = new JLabel("Enter the name of the customer to cancel");

        timeField = new JTextField(3);
        timeField.addActionListener(this);
        timeLabel = new JLabel("Enter the time the customer was booked for");

        submit = new JButton("Submit");
        submit.setActionCommand("myButton");
        submit.addActionListener(this);


        add(nameLabel);
        add(nameField);


        add(timeLabel);
        add(timeField);
        add(submit);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("myButton"))
        {
            c = new RegularCustomer(nameField.getText());
            c.setName(nameField.getText());
            try {
                c.setReservationTime(Integer.parseInt(timeField.getText()));
            } catch (InvalidTimeException e1) {
                e1.printStackTrace();
            } catch (BookingALreadyExistsException e1) {
                e1.printStackTrace();
            }
            r.getBooking().set(Integer.parseInt(timeField.getText()), null);
            r.ReservationList();
            ReservationsWindow rw = new ReservationsWindow();
            rw.setVisible(true);
            ex.setVisible(false);
        }

    }

    public static void main(String[] args) {
        ex.setVisible(true);
    }
}
