package com.MySchool.backend.database;

import com.MySchool.frontend.frames.WarningFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Component
public class DatabaseOperation {

    DatabaseConnector databaseConnector;
    Connection connection;
    WarningFrame warningFrame;

    @Autowired
    DatabaseOperation (DatabaseConnector databaseConnector, WarningFrame warningFrame) {
        this.databaseConnector = databaseConnector;
        this.connection = databaseConnector.connectDatabase();
        this.warningFrame = warningFrame;
    }

    public void checkLogin(int jobCode, String enteredUsername, String passwordString) {
        String query = "SELECT * FROM users WHERE jobcode = ? AND username = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, jobCode);
            preparedStatement.setString(2, enteredUsername);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String password = resultSet.getString("password");
                if (password.equals(passwordString)) {
                    System.out.println("Username & Password are correct");
                } else {
                    String warningTitle = "Credential Error";
                    String warningMessage = "Wrong username or password";
                    warningFrame.showWarningFrame(warningTitle, warningMessage);
                }
            } else {
                String warningTitle = "Role Error";
                String warningMessage = "Error : Enter a valid Role.";
                warningFrame.showWarningFrame(warningTitle, warningMessage);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
