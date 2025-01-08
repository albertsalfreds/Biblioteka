package main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class WelcomePage implements ActionListener {
    JFrame frame = new JFrame("GrāmatNīca");
    JLabel welcomeMessage = new JLabel("Laipni lūgti grāmatNīcā!");
    JButton addBookButton = new JButton("Pievienot grāmatu");
    JButton deleteBookButton = new JButton("Izdzēst grāmatu");
    JButton checkAvailabilityButton = new JButton("Pārbaudīt pieejamību");

    WelcomePage() {
        welcomeMessage.setForeground(Color.white);
        welcomeMessage.setBounds(200, 50, 300, 50);

// addBook
        addBookButton.setBounds(200, 150, 200, 40);
        addBookButton.addActionListener(this);
       new Pievienot();

// deleteBook
        deleteBookButton.setBounds(200, 220, 200, 40);
        deleteBookButton.addActionListener(this);

 // checkAvailable
        checkAvailabilityButton.setBounds(200, 290, 200, 40);
        checkAvailabilityButton.addActionListener(this);

// ramja Settingi
        frame.add(welcomeMessage);
        frame.add(addBookButton);
        frame.add(deleteBookButton);
        frame.add(checkAvailabilityButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
    }

//klauseklis
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBookButton) {
            System.out.println("Add book");

        }
        if (e.getSource() == deleteBookButton) {
            System.out.println("Remove book");

        }
        if (e.getSource() == checkAvailabilityButton) {
            System.out.println("Check");
        }
    }

    public static void main(String[] args) {
        new WelcomePage();
    }
}
