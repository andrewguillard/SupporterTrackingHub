/*
 * Created by JFormDesigner on Sun Jan 12 16:30:59 EST 2020
 */

package com.amg.supporttracker.gui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import com.amg.supporttracker.gui.util.*;
import com.amg.supporttracker.gui.util.dto.DonationDTO;
import net.miginfocom.swing.*;

/**
 * @author Andrew Guillard
 */
public class DonationScreen extends JPanel {

    private ArrayList<DonationDTO> loadedDonations;
    private ArrayList<STHeaderData> headers;

    public DonationScreen(Dimension dim) {
        loadData();
        this.headers = generateHeaders();
        initComponents();
        this.setSize(dim);

        loadUI();
    }

    private void loadUI(){
        //Create table headers
        donationTable.setHeaders(headers);
        donationTable.setTableData(loadedDonations);
    }

    private void loadData(){
        this.loadedDonations = XMLParser.readDonationsFile();
    }

    public void addDonation(DonationDTO donation){
        donationTable.addTableRow(donation);
        saveData(loadedDonations);
    }

    public void saveData(ArrayList<DonationDTO> donations){
        //validate? Maybe? idk
        XMLParser.writeDonationsFile(donations);
    }

    public ArrayList<STHeaderData> generateHeaders(){
        ArrayList<STHeaderData> headers = new ArrayList<>();
        headers.add(new STHeaderData("donationName", "Name", true));
        headers.add(new STHeaderData("friendlyName", "Friendly Name", true));
        headers.add(new STHeaderData("discordName", "Discord Name", true));
        headers.add(new STHeaderData("donationAmount", "Amount", true));
        headers.add(new STHeaderData("donationDate", "Donation Date", true));
        headers.add(new STHeaderData("source", "Source"));

        return headers;
    }

    private void btnAddDonationActionPerformed(ActionEvent e) {
        System.out.println("Adding a donation.");
        AddDonation addDonation = new AddDonation(this);
        addDonation.setVisible(true);
    }

    public STTable getDonationTable() {
        return donationTable;
    }

    public void setLookAndFeel(STLookAndFeel lookAndFeel){
        this.setBackground(lookAndFeel.getStreamlabsBackgroundColor());
        donationTopPanel.setBackground(lookAndFeel.getStreamlabsBackgroundColor());
        btnStreamLabsIntegration.setBackground(lookAndFeel.getStreamlabsPrimaryColor());
        btnStreamLabsIntegration.setForeground(lookAndFeel.getStreamlabsSecondaryColor());
        btnStreamLabsIntegration.setFont(lookAndFeel.getLargeFontBold());

        donationScrollPane.setBackground(lookAndFeel.getStreamlabsBackgroundColor());
        getDonationTable().setBackground(lookAndFeel.getStreamlabsBackgroundColor());
        getDonationTable().setForeground(lookAndFeel.getStreamlabsSecondaryColor());
        getDonationTable().setFont(lookAndFeel.getSmallFontPlain());
        getDonationTable().getTableHeader().setBackground(lookAndFeel.getStreamlabsPrimaryColor());
        getDonationTable().getTableHeader().setForeground(lookAndFeel.getStreamlabsSecondaryColor());
        getDonationTable().getTableHeader().setFont(lookAndFeel.getSmallFontBold());

        btnAddDonation.setBackground(lookAndFeel.getStreamlabsPrimaryColor());
        btnAddDonation.setForeground(lookAndFeel.getStreamlabsSecondaryColor());
        btnAddDonation.setFont(lookAndFeel.getLargeFontBold());

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Andrew Guillard
        donationTopPanel = new JPanel();
        btnStreamLabsIntegration = new JButton();
        donationScrollPane = new JScrollPane();
        donationTable = new STTable(null, this.headers);
        btnAddDonation = new JButton();

        //======== this ========
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder
        (0,0,0,0), "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn",javax.swing.border.TitledBorder.CENTER,javax.swing.border
        .TitledBorder.BOTTOM,new java.awt.Font("Dia\u006cog",java.awt.Font.BOLD,12),java.awt
        .Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void
        propertyChange(java.beans.PropertyChangeEvent e){if("\u0062ord\u0065r".equals(e.getPropertyName()))throw new RuntimeException()
        ;}});
        setLayout(new MigLayout(
            "insets 0,hidemode 3,gap 0 0",
            // columns
            "[grow,fill]",
            // rows
            "[60,fill]" +
            "[294,grow]" +
            "[]"));

        //======== donationTopPanel ========
        {
            donationTopPanel.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[fill]" +
                "[236,grow,fill]",
                // rows
                "[]"));

            //---- btnStreamLabsIntegration ----
            btnStreamLabsIntegration.setText("Connect to StreamLabs");
            donationTopPanel.add(btnStreamLabsIntegration, "cell 0 0");
        }
        add(donationTopPanel, "cell 0 0");

        //======== donationScrollPane ========
        {
            donationScrollPane.setViewportView(donationTable);
        }
        add(donationScrollPane, "cell 0 1");

        //---- btnAddDonation ----
        btnAddDonation.setText("Add Donation");
        btnAddDonation.addActionListener(e -> btnAddDonationActionPerformed(e));
        add(btnAddDonation, "cell 0 2");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Andrew Guillard
    private JPanel donationTopPanel;
    private JButton btnStreamLabsIntegration;
    private JScrollPane donationScrollPane;
    private STTable donationTable;
    private JButton btnAddDonation;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
