package com.amg.supporttracker.gui.util;

import com.amg.supporttracker.gui.MainScreen;

import javax.swing.*;

public class STContentFrame extends JFrame {
    
    MainScreen mainScreen;
    JFrame activeScreen;
    
    public STContentFrame(MainScreen main){
        this.mainScreen = main;
    }
    
    public void setActiveScreen(JFrame activeScreen){
        this.activeScreen = activeScreen;
    }

    public JFrame getActiveScreen() {
        return activeScreen;
    }
}
