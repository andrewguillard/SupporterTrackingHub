/*
 * Created by JFormDesigner on Sun Jan 12 16:30:59 EST 2020
 */

package com.amg.supporttracker.gui;

import java.awt.*;
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
    private ArrayList<STTableHeader> headers;

    public DonationScreen(Dimension dim) {
        loadData();
        this.headers = generateHeaders();
        initComponents();
        this.setSize(dim);
        textField1.setText("Donation");

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

    //TODO: Make an XML Parser to just add a patron. Not search through all of them.
    public void addPatron(DonationDTO donation){
        loadedDonations.add(donation);
        //insertPatronToTable(donation);
        saveData(loadedDonations);
    }

    public void saveData(ArrayList<DonationDTO> donations){
        //validate? Maybe? idk
        XMLParser.writeDonationsFile(donations);
    }

    public ArrayList<STTableHeader> generateHeaders(){
        ArrayList<STTableHeader> headers = new ArrayList<>();
        headers.add(new STTableHeader("donationName", "Name", true));
        headers.add(new STTableHeader("friendlyName", "Friendly Name", true));
        headers.add(new STTableHeader("discordName", "Discord Name", true));
        headers.add(new STTableHeader("donationAmount", "Amount", true));
        headers.add(new STTableHeader("donationDate", "Donation Date", true));
        headers.add(new STTableHeader("source", "Source"));

        return headers;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Andrew Guillard
        panel1 = new JPanel();
        textField1 = new JTextField();
        donarionScrollPane = new JScrollPane();
        donationTable = new STTable(null, this.headers);

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border
        . EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e", javax. swing. border. TitledBorder. CENTER, javax
        . swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dialo\u0067" ,java .awt .Font .BOLD ,
        12 ), java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans
        . PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("borde\u0072" .equals (e .
        getPropertyName () )) throw new RuntimeException( ); }} );
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

        //======== donarionScrollPane ========
        {
            donarionScrollPane.setViewportView(donationTable);
        }
        add(donarionScrollPane, "cell 1 1");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Andrew Guillard
    private JPanel panel1;
    private JTextField textField1;
    private JScrollPane donarionScrollPane;
    private STTable donationTable;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
