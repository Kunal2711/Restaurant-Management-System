package model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReservationsWindow extends JFrame implements ActionListener{

    private JLabel heading;
    private JTextArea times;
    private JButton home;
    private static ReservationsWindow rw = new ReservationsWindow();
    private Restaurant r;
    private MakeRegularBookingWindow mb;

    public ReservationsWindow(){
        super("New Booking");

        mb = new MakeRegularBookingWindow();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(20, 40, 500, 250);
        setLayout(new FlowLayout());

        r = new Restaurant();

        heading = new JLabel("Here is the reservation list");

        home = new JButton("Main Menu");
        home.setActionCommand("homeBtn");
        home.addActionListener(this);

        times = new JTextArea(10, 2);
        times.setEditable(false);
        //for(String s: r.getBooking())
        for (int i = 13; i < mb.getR().getBooking().size(); i++) {
            Customer c = mb.getR().getBooking().get(i);
            if (c != null) {
                times.append(i + "hrs: " + c.printName() + "\n");
            } else {
                times.append(i + "hrs: " + "available " + "\n");
            }
        }

        add(heading);
        add(times);
        add(home);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("homeBtn")){
            MainMenu ex = new MainMenu();
            ex.setVisible(true);
            mb.dispose();

        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            rw.setVisible(true);
        });
    }
}
