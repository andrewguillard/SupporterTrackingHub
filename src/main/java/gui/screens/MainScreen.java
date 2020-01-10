/*
 * Created by JFormDesigner on Fri Jan 10 01:32:53 EST 2020
 */

package main.java.gui.screens;

import java.awt.*;
import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author Andrew Guillard
 */
public class MainScreen extends JFrame {
    public MainScreen() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Andrew Guillard
        buttonPanel = new JPanel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        contentPanel = new JPanel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[168,fill]" +
            "[682,fill]",
            // rows
            "[445]"));

        //======== buttonPanel ========
        {
            buttonPanel.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder( 0
            , 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM
            , new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt. Color. red) ,
            buttonPanel. getBorder( )) ); buttonPanel. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
            ) {if ("bord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );
            buttonPanel.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[218,fill]",
                // rows
                "[40,shrink 0,fill]" +
                "[40,fill]" +
                "[40,fill]"));

            //---- button1 ----
            button1.setText("Dashboard");
            buttonPanel.add(button1, "cell 0 0");

            //---- button2 ----
            button2.setText("Patrons");
            buttonPanel.add(button2, "cell 0 1");

            //---- button3 ----
            button3.setText("Donations");
            buttonPanel.add(button3, "cell 0 2");
        }
        contentPane.add(buttonPanel, "cell 0 0");

        //======== contentPanel ========
        {
            contentPanel.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[fill]" +
                "[fill]",
                // rows
                "[182]" +
                "[]" +
                "[]"));
        }
        contentPane.add(contentPanel, "cell 1 0");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Andrew Guillard
    private JPanel buttonPanel;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JPanel contentPanel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
