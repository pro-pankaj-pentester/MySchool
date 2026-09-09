package com.MySchool.backend.logics;

import com.MySchool.frontend.frames.LoginFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppLauncher {

    LoginFrame loginFrame;

    @Autowired
    AppLauncher (LoginFrame loginFrame) {
        this.loginFrame = loginFrame;
    }

    public void launcherApp() {
        loginFrame.showLoginFrame();
    }
}
