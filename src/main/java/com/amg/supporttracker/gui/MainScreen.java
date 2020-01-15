/*
 * Created by JFormDesigner on Fri Jan 10 01:32:53 EST 2020
 */

package com.amg.supporttracker.gui;

import java.awt.event.*;
import net.miginfocom.swing.MigLayout;

import java.awt.*;
import javax.swing.*;

/**
 * @author Andrew Guillard
 */
public class MainScreen extends JFrame {

    CardLayout cardLayout;
    PatronScreen patronScreen;
    
    public MainScreen() {
        initComponents();
        initContentPanel();
        setColors();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Andrew Guillard
        buttonPanel = new JPanel();
        btnDashboard = new JButton();
        btnPatrons = new JButton();
        btnDonations = new JButton();
        btnDevAddPatron = new JButton();
        contentPanel = new JPanel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[168,fill]" +
            "[682,fill]",
            // rows
            "[41]" +
            "[153,top]" +
            "[254,grow]"));

        //======== buttonPanel ========
        {
            buttonPanel.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder
            (0,0,0,0), "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e",javax.swing.border.TitledBorder.CENTER,javax.swing.border
            .TitledBorder.BOTTOM,new java.awt.Font("D\u0069al\u006fg",java.awt.Font.BOLD,12),java.awt
            .Color.red),buttonPanel. getBorder()));buttonPanel. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void
            propertyChange(java.beans.PropertyChangeEvent e){if("\u0062or\u0064er".equals(e.getPropertyName()))throw new RuntimeException()
            ;}});
            buttonPanel.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[218,fill]",
                // rows
                "[199,grow]" +
                "[40,shrink 0,fill]" +
                "[40,fill]" +
                "[40,fill]" +
                "[]" +
                "[190,grow]"));

            //---- btnDashboard ----
            btnDashboard.setText("Dashboard");
            btnDashboard.addActionListener(e -> btnDashboardActionPerformed(e));
            buttonPanel.add(btnDashboard, "cell 0 1");

            //---- btnPatrons ----
            btnPatrons.setText("Patrons");
            btnPatrons.addActionListener(e -> btnPatronsActionPerformed(e));
            buttonPanel.add(btnPatrons, "cell 0 2");

            //---- btnDonations ----
            btnDonations.setText("Donations");
            btnDonations.addActionListener(e -> btnDonationsActionPerformed(e));
            buttonPanel.add(btnDonations, "cell 0 3");

            //---- btnDevAddPatron ----
            btnDevAddPatron.setText("DEV - Add Patron");
            btnDevAddPatron.addActionListener(e -> btnDevAddPatronActionPerformed(e));
            buttonPanel.add(btnDevAddPatron, "cell 0 4");
        }
        contentPane.add(buttonPanel, "cell 0 0 1 3");

        //======== contentPanel ========
        {
            contentPanel.setLayout(new CardLayout());
        }
        contentPane.add(contentPanel, "cell 1 0 1 3");
        pack();
        setLocationRelativeTo(getOwner());
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
        buttonPanel.setBackground(new Color(250,126,0));
        contentPanel.setBackground(new Color(77,77,77));
    }
    
    

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Andrew Guillard
    private JPanel buttonPanel;
    private JButton btnDashboard;
    private JButton btnPatrons;
    private JButton btnDonations;
    private JButton btnDevAddPatron;
    private JPanel contentPanel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
