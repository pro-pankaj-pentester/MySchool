package com.MySchool.tests;

import com.MySchool.frontend.frames.MainFrame;
import org.springframework.stereotype.Component;

@Component
public class MainFrameTest {

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();

        mainFrame.showMainFrame(1, "Pankaj Nayak");
    }

}
