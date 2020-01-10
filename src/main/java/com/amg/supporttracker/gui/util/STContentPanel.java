package com.amg.supporttracker.gui.util;

import com.amg.supporttracker.gui.MainScreen;

import javax.swing.*;

public class STContentPanel extends JPanel {
    
    MainScreen mainScreen;
    JFrame activeScreen;
    
    public STContentPanel(MainScreen main){
        this.mainScreen = main;
    }
    
    public void setActiveScreen(JFrame activeScreen){
        this.activeScreen = activeScreen;
    }

    public JFrame getActiveScreen() {
        return activeScreen;
    }
}
