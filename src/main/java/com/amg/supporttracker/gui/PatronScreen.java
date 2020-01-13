/*
 * Created by JFormDesigner on Sun Jan 12 16:30:59 EST 2020
 */

package com.amg.supporttracker.gui;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.amg.supporttracker.gui.util.JSONParser;
import com.amg.supporttracker.gui.util.STTable;

import com.amg.supporttracker.gui.util.STUtil;
import com.amg.supporttracker.gui.util.dto.PatronDTO;
import net.miginfocom.swing.*;

/**
 * @author Andrew Guillard
 */
public class PatronScreen extends JPanel {

    private ArrayList<PatronDTO> loadedPatrons;
    private DefaultTableModel tableModel;

    public PatronScreen(Dimension dim) {
        initComponents();
        this.setSize(dim);
        textField1.setText("Patron");

        loadUI();
        loadData();
    }

    private void loadUI(){
        //Create table headers
        tableModel = new DefaultTableModel();
        for(String header : getHeaderNames()){
            tableModel.addColumn(header);
        }
        patronTable.setModel(tableModel);
    }

    private void loadData(){
        JSONParser parser = new JSONParser();
        //TODO: Actually call the data from the thing
        //ArrayList<PatronDTO> loadedPatrons = parser.loadPatrons("patrons.json");

        //TESTING...
        loadedPatrons = new ArrayList<>();
        PatronDTO patron1 = new PatronDTO("Andrew", 1, 1, new Date());
        PatronDTO patron2 = new PatronDTO("Bill", 2, 4, new Date());
        PatronDTO patron3 = new PatronDTO("Alice", 1, 1, new Date());
        PatronDTO patron4 = new PatronDTO("Joe", 3, 15, new Date());
        PatronDTO patron5 = new PatronDTO("God", 4, 100, new Date());
        loadedPatrons.add(patron1);
        loadedPatrons.add(patron2);
        loadedPatrons.add(patron3);
        loadedPatrons.add(patron4);
        loadedPatrons.add(patron5);

        for(PatronDTO patron : loadedPatrons){
            System.out.println("Adding Patron: "+patron.getPatronName());
            tableModel.addRow(new Object[]{patron.getPatronName(), patron.getTierNum(), patron.getPledgeAmount(), STUtil.formatDate(patron.getPledgeDate(), "MM-dd-yyyy")});
        }
    }

    public ArrayList<String> getHeaderNames(){
        ArrayList<String> headers = new ArrayList<>();
        headers.add("Patron Name");
        headers.add("Tier");
        headers.add("Pledge Amount");
        headers.add("Pledge Date");

        return headers;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Andrew Guillard
        panel1 = new JPanel();
        textField1 = new JTextField();
        patronScrollPane = new JScrollPane();
        patronTable = new JTable();

        //======== this ========
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.
        border.EmptyBorder(0,0,0,0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion",javax.swing.border.TitledBorder.CENTER
        ,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("D\u0069alog",java.awt.Font
        .BOLD,12),java.awt.Color.red), getBorder())); addPropertyChangeListener(
        new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062order"
        .equals(e.getPropertyName()))throw new RuntimeException();}});
        setLayout(new MigLayout(
            "insets 0,hidemode 3,gap 0 0",
            // columns
            "[fill]" +
            "[grow,fill]" +
            "[fill]",
            // rows
            "[60,fill]" +
            "[294,grow]" +
            "[]"));

        //======== panel1 ========
        {
            panel1.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[236,grow,fill]",
                // rows
                "[]"));

            //---- textField1 ----
            textField1.setText("Hello Darkness my old friend.");
            panel1.add(textField1, "cell 0 0");
        }
        add(panel1, "cell 1 0");

        //======== patronScrollPane ========
        {
            patronScrollPane.setViewportView(patronTable);
        }
        add(patronScrollPane, "cell 1 1");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Andrew Guillard
    private JPanel panel1;
    private JTextField textField1;
    private JScrollPane patronScrollPane;
    private JTable patronTable;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
