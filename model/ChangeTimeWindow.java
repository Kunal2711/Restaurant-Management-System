package model;

import exceptions.BookingALreadyExistsException;
import exceptions.InvalidTimeException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class ChangeTimeWindow extends JFrame implements ActionListener{
    private JTextField nameField;
    private JLabel nameLabel;
    private JLabel oldtimeLabel;
    private JTextField oldtimeField;
    private JLabel newtimeLabel;
    private JTextField newtimeField;
    private JButton submit;
    private Customer c;
    private JTextArea times;
    private Restaurant r;
    private static ChangeTimeWindow ex = new ChangeTimeWindow();

    public ChangeTimeWindow(){
        super("Change Time");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(20, 40, 500, 250);
        // setPreferredSize(new Dimension(500, 250));
        setLayout(new FlowLayout());
        r = new Restaurant();



        nameField = new JTextField(20);
        nameField.addActionListener(this);
        nameLabel = new JLabel("Enter the name of the customer to change");

        oldtimeField = new JTextField(3);
        oldtimeField.addActionListener(this);
        oldtimeLabel = new JLabel("Enter the old time the customer was booked for");

        newtimeField = new JTextField(3);
        newtimeField.addActionListener(this);
        newtimeLabel = new JLabel("Enter the new time to book the customer for");

        submit = new JButton("Submit");
        submit.setActionCommand("myButton");
        submit.addActionListener(this);


        add(nameLabel);
        add(nameField);

        add(oldtimeLabel);
        add(oldtimeField);

        add(newtimeLabel);
        add(newtimeField);

        add(submit);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("myButton"))
        {
            c = new RegularCustomer(nameField.getText());
            c.setName(nameField.getText());
            try {
                c.setReservationTime(Integer.parseInt(newtimeField.getText()));
            } catch (InvalidTimeException e1) {
                e1.printStackTrace();
            } catch (BookingALreadyExistsException e1) {
                e1.printStackTrace();
            }
            //if(r.getBooking().contains(c) && r.getBooking().get(Integer.parseInt(newtimeField.getText())) == null){
                r.getBooking().set(Integer.parseInt(newtimeField.getText()), c);
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
