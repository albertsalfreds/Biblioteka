package main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.*;

public class LoginPage implements ActionListener {
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Pieslēgties");
    JButton resetButton = new JButton("Atiestatīt");
    JTextField userInputLauks = new JTextField();
    JPasswordField passwordInputLauks = new JPasswordField();
    JLabel userIdLabel = new JLabel("Lietotāja Id:");
    JLabel userPasswordLabel = new JLabel("Parole:");
    JLabel message = new JLabel();
    HashMap<String, String> loginInfo = new HashMap<>();

    LoginPage(HashMap<String, String> loginInfoOriginal) {
        loginInfo = loginInfoOriginal;

//ID text
        userIdLabel.setBounds(50, 100, 75, 25);
        userIdLabel.setForeground(Color.WHITE);
        
//parole text
        userPasswordLabel.setBounds(50, 150, 75, 25);
        userPasswordLabel.setForeground(Color.WHITE);
        
//inputLauki
        userInputLauks.setBounds(150, 100, 200, 25);
        passwordInputLauks.setBounds(150, 150, 200, 25);
        
//Pogas
        loginButton.setBounds(150, 200, 100, 25);
        loginButton.addActionListener(this);

        resetButton.setBounds(260, 200, 100, 25);
        resetButton.addActionListener(this);

//zinja
        message.setBounds(150, 250, 300, 25);
        message.setForeground(Color.WHITE);
//komponenti
        frame.add(userIdLabel);
        frame.add(userPasswordLabel);
        frame.add(userInputLauks);
        frame.add(passwordInputLauks);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.add(message);
//ramja settingi
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 350);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
    }


//klauseklis
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String userId = userInputLauks.getText().trim(); 
            String password = String.valueOf(passwordInputLauks.getPassword()).trim(); 
//parbaude
            if (loginInfo.containsKey(userId) && loginInfo.get(userId).equals(password)) {
                message.setText("Uzgaidi, lūdzu...");
                frame.setVisible(false);
                frame.dispose();
                new WelcomePage(); 
            } else {
                message.setText("Nepareiza parole vai ID!");  
            }
        }
//atiestatit
        if (e.getSource() == resetButton) {
            userInputLauks.setText("");
            passwordInputLauks.setText("");
            message.setText("");
        }
    }


    public static void main(String[] args) {
        Dati dati = new Dati(); 
        new LoginPage(dati.getLoginInfo());
    }
}






