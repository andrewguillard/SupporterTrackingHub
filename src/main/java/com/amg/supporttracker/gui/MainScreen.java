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
    
    public MainScreen() {
        initComponents();
        initContentPanel();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void btnDashboardActionPerformed(ActionEvent e) {
        System.out.println("Dashboard button clicked");
        
    }

    private void btnPatronsActionPerformed(ActionEvent e) {
        System.out.println("Patron button clicked");
        //PatronScreen patronScreen = new PatronScreen(contentPanel);
    }
    
    private void btnDonationsActionPerformed(ActionEvent e) {
        System.out.println("Donation button clicked");
        
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Andrew Guillard
        buttonPanel = new JPanel();
        btnDashboard = new JButton();
        btnPatrons = new JButton();
        btnDonations = new JButton();
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
            buttonPanel.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border.
            EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER, javax. swing
            . border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ),
            java. awt. Color. red) ,buttonPanel. getBorder( )) ); buttonPanel. addPropertyChangeListener (new java. beans. PropertyChangeListener( )
            { @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName () ))
            throw new RuntimeException( ); }} );
            buttonPanel.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[218,fill]",
                // rows
                "[40,shrink 0,fill]" +
                "[40,fill]" +
                "[40,fill]"));

            //---- btnDashboard ----
            btnDashboard.setText("Dashboard");
            btnDashboard.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    btnDashboardActionPerformed(e);
                }
            });
            buttonPanel.add(btnDashboard, "cell 0 0");

            //---- btnPatrons ----
            btnPatrons.setText("Patrons");
            btnPatrons.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    btnPatronsActionPerformed(e);
                }
            });
            buttonPanel.add(btnPatrons, "cell 0 1");

            //---- btnDonations ----
            btnDonations.setText("Donations");
            btnDonations.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    btnDonationsActionPerformed(e);
                }
            });
            buttonPanel.add(btnDonations, "cell 0 2");
        }
        contentPane.add(buttonPanel, "cell 0 1");

        //======== contentPanel ========
        {
            contentPanel.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[fill]" +
                "[fill]",
                // rows
                "[182]"));
        }
        contentPane.add(contentPanel, "cell 1 1 1 2");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    
    private void initContentPanel() {
        
    }
    
    

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Andrew Guillard
    private JPanel buttonPanel;
    private JButton btnDashboard;
    private JButton btnPatrons;
    private JButton btnDonations;
    private JPanel contentPanel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
