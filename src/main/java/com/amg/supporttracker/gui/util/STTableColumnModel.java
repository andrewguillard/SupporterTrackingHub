package com.amg.supporttracker.gui.util;

import javax.crypto.spec.PSource;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.ArrayList;

public class STTableColumnModel extends DefaultTableColumnModel {

    private ArrayList<STHeaderData> headers;
    private ArrayList<STHeaderData> sortHeaders;

    public STTableColumnModel(){
        super();
    }

    public STTableColumnModel(ArrayList<STHeaderData> headers){
        super();
        this.headers = new ArrayList<>();
        this.headers.addAll(headers);
    }

    //TODO: Create DEBUG logger (and INFO) to handle some of these logs.
    @Override
    public void moveColumn(int columnIndex, int newIndex){
        if(columnIndex != newIndex) {
            System.out.println("Column Moved! New pos: " + newIndex);
            shiftHeaders(columnIndex, newIndex);

//            for(STHeaderData header : headers){
//                System.out.println("Header: "+header.getDisplay());
//            }
        }
        //Actually does the column moving animation
        super.moveColumn(columnIndex, newIndex);
    }

    private void shiftHeaders(int initialPos, int newPos){
        STHeaderData movedHeader = headers.get(initialPos);
        headers.remove(initialPos);
        headers.add(newPos, movedHeader);
    }

    //TODO: Probably need to do stuff to make the headers actually go on the table
    public ArrayList<STHeaderData> getHeaders() {
        return headers;
    }

    public void setHeaders(ArrayList<STHeaderData> headers) {
        this.headers = headers;
    }

    public void toggleSort(int col){
        if(sortHeaders == null){
            sortHeaders = new ArrayList<>();
        }
        headers.get(col).toggleSort();
        sortHeaders.add(headers.get(col));
        setSortIcon(col, headers.get(col));
    }

    //Remove all other sorts and set this header as the only sort
    public void setSort(int col){
        if(sortHeaders != null) {
            //GO through current sorts and set their sort symbol to ""
            for (STHeaderData header : sortHeaders) {
                header.resetSort();
            }
        }
        sortHeaders = new ArrayList<>();
        headers.get(col).setSort();
        sortHeaders.add(headers.get(col));
    }

    public void setSortIcon(int col, STHeaderData header){
    }

    //Build sort list based on columns of sort
    public ArrayList<String> getSorts(){
        ArrayList<String> sorts = new ArrayList<>();
        for(STHeaderData sortHeader : sortHeaders){
            sorts.add(sortHeader.getSortSymbol() + sortHeader.getProperty());
        }
        return sorts;
    }
}
