/*
 * Created by JFormDesigner on Wed Jan 15 14:19:22 EST 2020
 */

package com.amg.supporttracker.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.amg.supporttracker.gui.util.STStandard;
import com.amg.supporttracker.gui.util.STUtil;
import com.amg.supporttracker.gui.util.dto.DonationDTO;
import com.amg.supporttracker.gui.util.dto.PatronDTO;
import net.miginfocom.swing.*;

/**
 * @author Andrew Guillard
 */
public class AddDonation extends JDialog {
    
    DonationScreen donationScreen;
    
    public AddDonation(DonationScreen donationScreen) {
        this.donationScreen = donationScreen;
        initComponents();
        loadUI();
    }

    private void btnSubmitActionPerformed(ActionEvent e) {
        //Save donation
        DonationDTO donation = new DonationDTO();
        donation.setDonationId(Integer.parseInt(txtDonationId.getText()));
        donation.setDonationName(txtDonationName.getText());
        donation.setFriendlyName(txtFriendlyName.getText());
        donation.setDiscordName(txtDiscordName.getText());
        donation.setDonationAmount(Double.parseDouble(txtDonationAmount.getText()));
        donation.setDonationDate(STUtil.formatStringToDate(txtDonationDate.getText(), STStandard.XML_DATE_FORMAT));
        donation.setSource(cboSource.getSelectedItem().toString());
        
        donationScreen.addPatron(donation);
        dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Andrew Guillard
        label1 = new JLabel();
        txtDonationId = new JTextField();
        label2 = new JLabel();
        txtDonationName = new JTextField();
        label3 = new JLabel();
        txtFriendlyName = new JTextField();
        label4 = new JLabel();
        txtDiscordName = new JTextField();
        label6 = new JLabel();
        txtDonationAmount = new JTextField();
        label8 = new JLabel();
        txtDonationDate = new JTextField();
        label10 = new JLabel();
        cboSource = new JComboBox();
        btnSubmit = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[123,fill]" +
            "[186,fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- label1 ----
        label1.setText("Donation ID");
        contentPane.add(label1, "cell 0 0");
        contentPane.add(txtDonationId, "cell 1 0");

        //---- label2 ----
        label2.setText("Name");
        contentPane.add(label2, "cell 0 1");
        contentPane.add(txtDonationName, "cell 1 1");

        //---- label3 ----
        label3.setText("Friendly Name");
        contentPane.add(label3, "cell 0 2");
        contentPane.add(txtFriendlyName, "cell 1 2");

        //---- label4 ----
        label4.setText("Discord Name");
        contentPane.add(label4, "cell 0 3");
        contentPane.add(txtDiscordName, "cell 1 3");

        //---- label6 ----
        label6.setText("Amount");
        contentPane.add(label6, "cell 0 4");
        contentPane.add(txtDonationAmount, "cell 1 4");

        //---- label8 ----
        label8.setText("Date");
        contentPane.add(label8, "cell 0 5");
        contentPane.add(txtDonationDate, "cell 1 5");

        //---- label10 ----
        label10.setText("Source");
        contentPane.add(label10, "cell 0 6");
        contentPane.add(cboSource, "cell 1 6");

        //---- btnSubmit ----
        btnSubmit.setText("Add Donation");
        btnSubmit.addActionListener(e -> btnSubmitActionPerformed(e));
        contentPane.add(btnSubmit, "cell 0 7 2 1");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    
    private void loadUI(){
        cboSource.addItem("user");
        cboSource.addItem("streamlabs");
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Andrew Guillard
    private JLabel label1;
    private JTextField txtDonationId;
    private JLabel label2;
    private JTextField txtDonationName;
    private JLabel label3;
    private JTextField txtFriendlyName;
    private JLabel label4;
    private JTextField txtDiscordName;
    private JLabel label6;
    private JTextField txtDonationAmount;
    private JLabel label8;
    private JTextField txtDonationDate;
    private JLabel label10;
    private JComboBox cboSource;
    private JButton btnSubmit;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
