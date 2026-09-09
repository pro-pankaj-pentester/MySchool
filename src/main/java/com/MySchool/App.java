package com.MySchool;

import com.MySchool.backend.database.DatabaseConnector;
import com.MySchool.backend.logics.AppConfig;
import com.MySchool.backend.logics.AppLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        DatabaseConnector databaseConnector = context.getBean(DatabaseConnector.class);
        AppLauncher launcher = context.getBean(AppLauncher.class);

        databaseConnector.connectDatabase();
        launcher.launcherApp();

    }
}