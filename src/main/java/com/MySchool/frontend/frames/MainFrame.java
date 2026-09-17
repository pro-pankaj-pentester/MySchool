package com.MySchool.frontend.frames;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class MainFrame {

    JFrame mainFrame;
    JPanel mainPanel;

    public void showMainFrame(int jobCode, String username) {
        mainFrame = new JFrame();
        mainPanel = new JPanel();

        if (jobCode == 1) {
            // adminHeadingPanel initialization
            JPanel adminHeadingPanel = new JPanel();

            // welcomeLabel options
            JLabel welcomeLabel = new JLabel("Welcome, " + username);
            welcomeLabel.setBounds(100, 20, 600, 50);
            welcomeLabel.setFont(new Font("Inter", Font.BOLD, 40));
            welcomeLabel.setForeground(new Color(220, 220, 220));
            adminHeadingPanel.add(welcomeLabel);

            // adminHeadingPanel options
            adminHeadingPanel.setBounds(0, 0, 1450, 100);
            adminHeadingPanel.setLayout(null);
            adminHeadingPanel.setBackground(new Color(40, 40, 40));
            mainPanel.add(adminHeadingPanel);

            // mainPanel options
            mainPanel.setBounds(0, 0, 1450, 850);
            mainPanel.setBackground(new Color(30, 30, 30));
            mainPanel.setLayout(null);
            mainFrame.add(mainPanel);
        }

        // mainFrame options
        mainFrame.setSize(1450, 850);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setTitle(username);
        mainFrame.setVisible(true);

    }

}
