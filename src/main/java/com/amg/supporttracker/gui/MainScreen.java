/*
 * Created by JFormDesigner on Fri Jan 10 01:32:53 EST 2020
 */

package com.amg.supporttracker.gui;

import java.awt.event.*;

import com.amg.supporttracker.gui.util.STStandard;
import net.miginfocom.swing.MigLayout;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

/**
 * @author Andrew Guillard
 */
public class MainScreen {

    CardLayout cardLayout;
    PatronScreen patronScreen;
    
    public MainScreen() {
        initComponents();
        initContentPanel();
        setColors();
        mainPanel.setVisible(true);
        mainPanel.setSize(new Dimension(800,500));
        mainPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void btnDashboardActionPerformed(ActionEvent e) {
        System.out.println("Dashboard button clicked");
        cardLayout.show(contentPanel, "dashboardScreenCard");
        
    }

    private void btnPatronsActionPerformed(ActionEvent e) {
        System.out.println("Patron button clicked");
        cardLayout.show(contentPanel, "patronScreenCard");
        //PatronScreen patronScreen = new PatronScreen(contentPanel);
    }
    
    private void btnDonationsActionPerformed(ActionEvent e) {
        System.out.println("Donation button clicked");
        cardLayout.show(contentPanel, "donationScreenCard");
    }

    private void btnDevAddPatronActionPerformed(ActionEvent e) {
        System.out.println("Add Patron button clicked");
        AddPatron addPatron = new AddPatron(patronScreen);
        addPatron.setVisible(true);
    }

    private void btnExitActionPerformed(ActionEvent e) {
        mainPanel.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Andrew Guillard
        mainPanel = new JFrame();
        buttonPanel = new JPanel();
        btnDashboard = new JButton();
        btnPatrons = new JButton();
        btnDonations = new JButton();
        btnDevAddPatron = new JButton();
        contentPanel = new JPanel();

        //======== mainPanel ========
        {
            Container mainPanelContentPane = mainPanel.getContentPane();
            mainPanelContentPane.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "0[185,fill]0" +
                "[682,grow,fill]0",
                // rows
                "0[254,growprio 50,grow,fill]0"));

            //======== buttonPanel ========
            {
                buttonPanel.setBackground(new Color(255, 102, 0));
                buttonPanel.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder(
                0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder
                . BOTTOM, new java .awt .Font ("D\u0069alog" ,java .awt .Font .BOLD ,12 ), java. awt. Color.
                red) ,buttonPanel. getBorder( )) ); buttonPanel. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .
                beans .PropertyChangeEvent e) {if ("\u0062order" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );
                buttonPanel.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "0[218,fill]0",
                    // rows
                    "[]0" +
                    "[50,shrinkprio 50,sizegroup 1,fill]0" +
                    "[50,shrinkprio 50,sizegroup 1,fill]0" +
                    "[40,shrinkprio 50,sizegroup 1,fill]0" +
                    "[shrinkprio 50,sizegroup 1]0" +
                    "[190,growprio 60,grow,fill]0"));

                //---- btnDashboard ----
                btnDashboard.setText("Dashboard");
                btnDashboard.setBackground(new Color(255, 102, 0));
                btnDashboard.addActionListener(e -> btnDashboardActionPerformed(e));
                buttonPanel.add(btnDashboard, "cell 0 1");

                //---- btnPatrons ----
                btnPatrons.setText("Patrons");
                btnPatrons.setBackground(new Color(255, 102, 0));
                btnPatrons.addActionListener(e -> btnPatronsActionPerformed(e));
                buttonPanel.add(btnPatrons, "cell 0 2");

                //---- btnDonations ----
                btnDonations.setText("Donations");
                btnDonations.setBackground(new Color(255, 102, 0));
                btnDonations.addActionListener(e -> btnDonationsActionPerformed(e));
                buttonPanel.add(btnDonations, "cell 0 3");

                //---- btnDevAddPatron ----
                btnDevAddPatron.setText("DEV - Add Patron");
                btnDevAddPatron.setBackground(new Color(255, 102, 0));
                btnDevAddPatron.addActionListener(e -> btnDevAddPatronActionPerformed(e));
                buttonPanel.add(btnDevAddPatron, "cell 0 4");
            }
            mainPanelContentPane.add(buttonPanel, "cell 0 0");

            //======== contentPanel ========
            {
                contentPanel.setLayout(new CardLayout());
            }
            mainPanelContentPane.add(contentPanel, "cell 1 0");
            mainPanel.pack();
            mainPanel.setLocationRelativeTo(mainPanel.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    
    private void initContentPanel() {
        this.cardLayout = (CardLayout) contentPanel.getLayout();

        DashboardScreen dashboardScreen = new DashboardScreen(contentPanel.getSize());
        contentPanel.add(dashboardScreen, "dashboardScreenCard");

        patronScreen = new PatronScreen(contentPanel.getSize());
        contentPanel.add(patronScreen, "patronScreenCard");

        DonationScreen donationScreen = new DonationScreen(contentPanel.getSize());
        contentPanel.add(donationScreen, "donationScreenCard");


    }

    private void setColors(){
        //Set Button Panel Color
        buttonPanel.setBackground(new Color(250,126,0));
        Border emptyBorder = BorderFactory.createEmptyBorder();

        //Set Button Colors
        btnDashboard.setBackground(STStandard.LF_DEFAULT_SIDEBAR_BTN);
        btnDashboard.setForeground(STStandard.LF_DEFAULT_SIDEBAR_BTN_TEXT);
        btnDashboard.setBorder(emptyBorder);

        btnPatrons.setBackground(STStandard.LF_DEFAULT_SIDEBAR_BTN);
        btnPatrons.setForeground(STStandard.LF_DEFAULT_SIDEBAR_BTN_TEXT);
        btnPatrons.setBorder(emptyBorder);

        btnDonations.setBackground(STStandard.LF_DEFAULT_SIDEBAR_BTN);
        btnDonations.setForeground(STStandard.LF_DEFAULT_SIDEBAR_BTN_TEXT);
        btnDonations.setBorder(emptyBorder);

        patronScreen.setBackground(new Color(77,77,77));
        mainPanel.setBackground(new Color(77,77,77));
        //exitPanel.setBackground(new Color(0,0,0));



        contentPanel.setBackground(new Color(77,77,77));
    }
    
    

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Andrew Guillard
    private JFrame mainPanel;
    private JPanel buttonPanel;
    private JButton btnDashboard;
    private JButton btnPatrons;
    private JButton btnDonations;
    private JButton btnDevAddPatron;
    private JPanel contentPanel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
