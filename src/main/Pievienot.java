package main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Pievienot {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pievienot grāmatu");
        JLabel label = new JLabel("Grāmatas nosaukums:");
        JTextField textField = new JTextField();
        JButton addButton = new JButton("Pievienot grāmatu");

//textInputLauks
        textField.setBounds(20, 50, 250, 25);
//teksts
        label.setBounds(20, 20, 200, 25);
//poga
        addButton.setBounds(20, 90, 150, 25);
        
//klauseklis
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String bookName = textField.getText().trim();
                if (!bookName.isEmpty()) {
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter("./books.txt", true))) {
                        writer.write(bookName + ",true");
                        writer.newLine();
                        JOptionPane.showMessageDialog(frame, "Grāmata pievienota: " + bookName);
                        textField.setText(""); // Clera
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(frame, "Kļūda rakstot failā: " + ex.getMessage(), "Kļūda", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Lūdzu ievadiet grāmatas nosaukumu.", "Kļūda", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //Komponenti
        frame.add(label);
        frame.add(textField);
        frame.add(addButton);

        // Ramja settingi
        frame.setSize(300, 200);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
