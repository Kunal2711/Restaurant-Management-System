package model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainMenu extends JFrame {

    private JLabel label;
    private JPanel panel;
    private static MainMenu mm = new MainMenu();


    public MainMenu() {

        initUI();
    }

    private void initUI() {

        createMenuBar();

        setTitle("Booking Menu");
        setSize(360, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        label = new JLabel("Welcome to Pi(a)zza Restaurant",JLabel.CENTER);
        //setBackground(Color.red);
//        JFrame frame = new JFrame();
//        frame.setContentPane(new MainMenu().panel);
//        frame.setVisible(true);
    }

    private void createMenuBar() {

        JMenuBar menubar = new JMenuBar();

        JMenu makeBooking = new JMenu("New Booking");
//        makeBooking.setActionCommand("new");
//        makeBooking.setMnemonic(1);
//        makeBooking.addActionListener(this::actionPerformed);

        JMenuItem newCustomer = new JMenuItem("New Customer");
        newCustomer.setActionCommand("new");
        newCustomer.addActionListener(this::actionPerformed);

        JMenuItem rewardCustomer = new JMenuItem("Existing Rewards Member");
        rewardCustomer.setActionCommand("rewards");
        rewardCustomer.addActionListener(this::actionPerformed);

        JMenu changeBooking = new JMenu("Manage Booking");

        JMenu exit = new JMenu("Exit");

        JMenuItem exititem = new JMenuItem("Are you sure you want to exit?");
        exititem.setActionCommand("exit");
        exititem.addActionListener(this::actionPerformed);

        exit.add(exititem);


        JMenuItem changeTime = new JMenuItem("Change Booking Time");
        changeTime.setActionCommand("time");
        changeTime.addActionListener(this::actionPerformed);

        JMenuItem cancelBooking = new JMenuItem("Cancel Booking");
        cancelBooking.setActionCommand("cancel");
        cancelBooking.addActionListener(this::actionPerformed);

        makeBooking.add(newCustomer);
        makeBooking.add(rewardCustomer);

        changeBooking.add(changeTime);
        changeBooking.add(cancelBooking);

        menubar.add(makeBooking);
        menubar.add(changeBooking);
        menubar.add(exit);

        //add(label);
        setJMenuBar(menubar);

    }



        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("new")) {
                MakeRegularBookingWindow mb = new MakeRegularBookingWindow();
                mb.setVisible(true);
                mm.setVisible(false);
            }
            else if(e.getActionCommand().equals("rewards")){
                MakeRegularBookingWindow mb = new MakeRegularBookingWindow();
                mb.setVisible(true);
                mm.setVisible(false);
            }
            else if (e.getActionCommand().equals("time")){
                ChangeTimeWindow ct = new ChangeTimeWindow();
                ct.setVisible(true);
                mm.setVisible(false);
            }
            else if(e.getActionCommand().equals("cancel")){
                CancelBookingWindow cb = new CancelBookingWindow();
                cb.setVisible(true);
                mm.dispose();
            }
            else if(e.getActionCommand().equals("exit")){
                System.exit(0);
            }
        }



    public static void main(String[] args) {

//        JFrame frame = new JFrame();
//        frame.setContentPane(new MainMenu().panel);
//        frame.setVisible(true);
        EventQueue.invokeLater(() -> {
            mm.setVisible(true);
        });
    }
}