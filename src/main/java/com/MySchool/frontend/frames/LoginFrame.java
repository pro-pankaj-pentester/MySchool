package com.MySchool.frontend.frames;

import com.MySchool.backend.database.DatabaseOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class LoginFrame implements ActionListener {

    DatabaseOperation databaseOperation;

    JFrame loginFrame;
    JPanel mainPanel;
    JComboBox<String> roleMenu;
    String[] roles = {"Select Role", "School Manager", "Class Teacher", "Teacher", "Class Monitor", "Student"};
    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginButton;

    @Autowired
    public LoginFrame(DatabaseOperation databaseOperation) {
        this.databaseOperation = databaseOperation;
    }

    public void showLoginFrame() {
        // loginFrame and mainPanel initialization
        loginFrame = new JFrame();
        mainPanel = new JPanel();
        Font inter25 = new Font("Inter", Font.BOLD, 25);
        Font inter20 = new Font("Inter", Font.PLAIN, 20);
        Font arial16 = new Font("Arial", Font.BOLD, 16);

        // welcomeLabel options
        JLabel welcomeLabel = new JLabel("Login Your Identity : ");
        welcomeLabel.setBounds(170, 30, 300, 30);
        welcomeLabel.setFont(inter25);
        welcomeLabel.setForeground(new Color(220, 220, 220));
        mainPanel.add(welcomeLabel);

        // roleLabel options
        JLabel roleLabel = new JLabel("Role : ");
        roleLabel.setBounds(100, 100, 60, 30);
        roleLabel.setForeground(new Color(220, 220, 220));
        roleLabel.setFont(inter20);
        mainPanel.add(roleLabel);

        // roleMenu options
        roleMenu = new JComboBox<>(roles);
        roleMenu.setBounds(190, 95, 300, 40);
        roleMenu.setForeground(new Color(220, 220, 220));
        roleMenu.setFont(arial16);
        roleMenu.setBorder(new LineBorder(new Color(100, 100, 100), 2, true));
        roleMenu.setBackground(new Color(40, 40, 40));
        roleMenu.setSelectedIndex(0);
        roleMenu.addActionListener(this);
        mainPanel.add(roleMenu);

        // usernameLabel options
        JLabel usernameLabel = new JLabel("Username : ");
        usernameLabel.setBounds(45, 160, 200, 40);
        usernameLabel.setFont(inter20);
        usernameLabel.setForeground(new Color(220, 220, 220));
        mainPanel.add(usernameLabel);

        // passwordLabel options
        JLabel passwordLabel = new JLabel("Password : ");
        passwordLabel.setBounds(50, 220, 200, 40);
        passwordLabel.setFont(inter20);
        passwordLabel.setForeground(new Color(220, 220, 220));
        mainPanel.add(passwordLabel);

        // usernameField options
        usernameField = new JTextField();
        usernameField.setBounds(190, 160, 300, 40);
        usernameField.setCaretColor(Color.white);
        uiFormatter(arial16, usernameField);

        // usernameField options
        passwordField = new JPasswordField();
        passwordField.setBounds(190, 225, 300, 40);
        passwordField.setCaretColor(Color.white);
        uiFormatter(arial16, passwordField);

        // loginButton options
        loginButton = new JButton("LOGIN");
        loginButton.setBounds(190, 300, 300, 40);
        loginButton.setForeground(new Color(220, 220, 220));
        loginButton.setBackground(new Color(40, 40, 40));
        loginButton.setFont(inter20);
        loginButton.setBorder(new LineBorder(new Color(100, 100, 100), 2, true));
        loginButton.addActionListener(this);
        mainPanel.add(loginButton);

        // mainPanel options
        mainPanel.setBounds(0, 0, 600, 400);
        mainPanel.setBackground(new Color(30, 30, 30));
        mainPanel.setLayout(null);
        loginFrame.add(mainPanel);

        // loginFrame options
        loginFrame.setSize(600, 400);
        loginFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        loginFrame.setResizable(false);
        loginFrame.setLayout(null);
        loginFrame.setTitle("MySchool Login");
        loginFrame.setLocation(400, 300);
        loginFrame.setVisible(true);
    }

    private void uiFormatter(Font arial16, JTextField usernameField) {
        usernameField.setFont(arial16);
        usernameField.setForeground(new Color(220, 220, 220));
        usernameField.setBackground(new Color(40, 40, 40));
        usernameField.setBorder(new LineBorder(new Color(100, 100, 100), 2, true));
        usernameField.addActionListener(this);
        mainPanel.add(usernameField);
    }

    @Override
    public void actionPerformed (ActionEvent e) {
        if(e.getSource() == loginButton) {
            int jobCode = roleMenu.getSelectedIndex();
            String enteredUsername = usernameField.getText();
            char[] passwordChar = passwordField.getPassword();
            String passwordString = new String(passwordChar);

            databaseOperation.checkLogin(jobCode, enteredUsername, passwordString);
        }
    }

}
