package com.MySchool.frontend.frames;

import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class WarningFrame implements ActionListener {

    JFrame warningFrame;
    JPanel mainPanel;
    JButton okayButton;
    Font inter20 = new Font("Inter", Font.BOLD, 20);

    public void showWarningFrame(String warningTitle, String warningMessage) {
        // warningFrame and mainPanel initialization
        warningFrame = new JFrame();
        mainPanel = new JPanel();

        // warningMessageLabel options
        JLabel warningMessageLabel = new JLabel(warningMessage);
        warningMessageLabel.setBounds(50, 30, 600, 40);
        warningMessageLabel.setFont(inter20);
        warningMessageLabel.setForeground(new Color(220, 220, 220));
        mainPanel.add(warningMessageLabel);

        // okayButton options
        okayButton = new JButton("OK");
        okayButton.setBounds(275, 120, 150, 40);
        okayButton.setFont(inter20);
        okayButton.setBackground(new Color(40, 40, 40));
        okayButton.setFocusPainted(false);
        okayButton.setForeground(new Color(220, 220, 220));
        okayButton.setBorder(new LineBorder(new Color(100, 100, 100), 2, true));
        okayButton.addActionListener(this);
        mainPanel.add(okayButton);

        // mainPanel options
        mainPanel.setBounds(0, 0, 700, 200);
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(30, 30, 30));
        warningFrame.add(mainPanel);

        // warningFrame options
        warningFrame.setSize(700, 200);
        warningFrame.setTitle(warningTitle);
        warningFrame.setResizable(false);
        warningFrame.setLayout(null);
        warningFrame.setLocation(610, 440);
        warningFrame.setVisible(true);
    }
    @Override
    public void actionPerformed (ActionEvent e) {
        if (e.getSource() == okayButton) {
            warningFrame.dispose();
        }
    }

}
