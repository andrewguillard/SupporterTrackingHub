/*
 * Created by JFormDesigner on Wed Jan 15 14:19:22 EST 2020
 */

package com.amg.supporttracker.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.amg.supporttracker.gui.util.STStandard;
import com.amg.supporttracker.gui.util.STUtil;
import com.amg.supporttracker.gui.util.dto.PatronDTO;
import net.miginfocom.swing.*;

/**
 * @author Andrew Guillard
 */
public class AddPatron extends JDialog {
    
    PatronScreen patronScreen;
    
    public AddPatron(PatronScreen patronScreen) {
        this.patronScreen = patronScreen;
        initComponents();
        loadUI();
    }

    private void btnSubmitActionPerformed(ActionEvent e) {
        //Save patron
        PatronDTO patron = new PatronDTO();
        patron.setPatronId(Integer.parseInt(txtPatronId.getText()));
        patron.setPatronName(txtPatronName.getText());
        patron.setFriendlyName(txtFriendlyName.getText());
        patron.setDiscordName(txtDiscordName.getText());
        patron.setTierNum(Integer.parseInt(cboTierNum.getSelectedItem().toString()));
        patron.setPledgeAmount(Double.parseDouble(txtPledgeAmount.getText()));
        patron.setTotalAmount(Double.parseDouble(txtTotalAmount.getText()));
        patron.setPledgeDate(STUtil.formatStringToDate(txtPledgeDate.getText(), STStandard.XML_DATE_FORMAT));
        patron.setDeclineDate(STUtil.formatStringToDate(txtDeclineDate.getText(), STStandard.XML_DATE_FORMAT));
        patron.setSource(cboSource.getSelectedItem().toString());
        
        patronScreen.addPatron(patron);
        dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Andrew Guillard
        label1 = new JLabel();
        txtPatronId = new JTextField();
        label2 = new JLabel();
        txtPatronName = new JTextField();
        label3 = new JLabel();
        txtFriendlyName = new JTextField();
        label4 = new JLabel();
        txtDiscordName = new JTextField();
        label5 = new JLabel();
        cboTierNum = new JComboBox();
        label6 = new JLabel();
        txtPledgeAmount = new JTextField();
        label7 = new JLabel();
        txtTotalAmount = new JTextField();
        label8 = new JLabel();
        txtPledgeDate = new JTextField();
        label9 = new JLabel();
        txtDeclineDate = new JTextField();
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
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- label1 ----
        label1.setText("Patron ID");
        contentPane.add(label1, "cell 0 0");
        contentPane.add(txtPatronId, "cell 1 0");

        //---- label2 ----
        label2.setText("Patron Name");
        contentPane.add(label2, "cell 0 1");
        contentPane.add(txtPatronName, "cell 1 1");

        //---- label3 ----
        label3.setText("Friendly Name");
        contentPane.add(label3, "cell 0 2");
        contentPane.add(txtFriendlyName, "cell 1 2");

        //---- label4 ----
        label4.setText("Discord Name");
        contentPane.add(label4, "cell 0 3");
        contentPane.add(txtDiscordName, "cell 1 3");

        //---- label5 ----
        label5.setText("Tier Num");
        contentPane.add(label5, "cell 0 4");
        contentPane.add(cboTierNum, "cell 1 4");

        //---- label6 ----
        label6.setText("Pledge Amount");
        contentPane.add(label6, "cell 0 5");
        contentPane.add(txtPledgeAmount, "cell 1 5");

        //---- label7 ----
        label7.setText("Total Amount");
        contentPane.add(label7, "cell 0 6");
        contentPane.add(txtTotalAmount, "cell 1 6");

        //---- label8 ----
        label8.setText("Pledge Date");
        contentPane.add(label8, "cell 0 7");
        contentPane.add(txtPledgeDate, "cell 1 7");

        //---- label9 ----
        label9.setText("Decline Date");
        contentPane.add(label9, "cell 0 8");
        contentPane.add(txtDeclineDate, "cell 1 8");

        //---- label10 ----
        label10.setText("Source");
        contentPane.add(label10, "cell 0 9");
        contentPane.add(cboSource, "cell 1 9");

        //---- btnSubmit ----
        btnSubmit.setText("Add Patron");
        btnSubmit.addActionListener(e -> btnSubmitActionPerformed(e));
        contentPane.add(btnSubmit, "cell 0 10 2 1");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    
    private void loadUI(){
        cboTierNum.addItem("1");
        cboTierNum.addItem("2");
        cboTierNum.addItem("3");
        cboTierNum.addItem("4");
        cboTierNum.addItem("5");
        
        cboSource.addItem("user");
        cboSource.addItem("patreon");
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Andrew Guillard
    private JLabel label1;
    private JTextField txtPatronId;
    private JLabel label2;
    private JTextField txtPatronName;
    private JLabel label3;
    private JTextField txtFriendlyName;
    private JLabel label4;
    private JTextField txtDiscordName;
    private JLabel label5;
    private JComboBox cboTierNum;
    private JLabel label6;
    private JTextField txtPledgeAmount;
    private JLabel label7;
    private JTextField txtTotalAmount;
    private JLabel label8;
    private JTextField txtPledgeDate;
    private JLabel label9;
    private JTextField txtDeclineDate;
    private JLabel label10;
    private JComboBox cboSource;
    private JButton btnSubmit;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
