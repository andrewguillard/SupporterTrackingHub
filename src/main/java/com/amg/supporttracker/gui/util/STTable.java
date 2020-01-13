package com.amg.supporttracker.gui.util;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.util.ArrayList;

public class STTable extends JTable {

    private ArrayList<String> headerNames;

    public STTable(){
        super();
    }

    public void setHeaders(String... headerNames){
        TableColumn newCol;
        for(String header : headerNames){
            newCol = new TableColumn();
            newCol.setHeaderValue(header);
            this.addColumn(newCol);
        }
    }

}
