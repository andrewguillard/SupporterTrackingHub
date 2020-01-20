package com.amg.supporttracker.gui.util;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.ArrayList;

public class STTableColumnModel extends DefaultTableColumnModel {

    ArrayList<STTableHeader> headers;
    ArrayList<STTableHeader> sortHeaders;

    public STTableColumnModel(){
        super();
    }

    public STTableColumnModel(ArrayList<STTableHeader> headers){
        super();
        this.headers = headers;
    }

    //TODO: Create DEBUG logger (and INFO) to handle some of these logs.
    @Override
    public void moveColumn(int columnIndex, int newIndex){
        if(columnIndex != newIndex) {
            System.out.println("Column Moved! New pos: " + newIndex);
            shiftHeaders(columnIndex, newIndex);
            System.out.println("First 3 = "+headers.get(0).getProperty()+" - "+headers.get(1).getProperty()+" - "+headers.get(2).getProperty());
        }

        //Actually does the column moving animation
        super.moveColumn(columnIndex, newIndex);
    }

    private void shiftHeaders(int initialPos, int newPos){
        STTableHeader movedHeader = headers.get(initialPos);
        headers.remove(initialPos);
        headers.add(newPos, movedHeader);
    }

    //TODO: Probably need to do stuff to make the headers actually go on the table
    public ArrayList<STTableHeader> getHeaders() {
        return headers;
    }

    public void setHeaders(ArrayList<STTableHeader> headers) {
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
        //GO through current sorts and set their sort symbol to ""
        for(STTableHeader header : sortHeaders){
            header.resetSort();
        }
        sortHeaders = new ArrayList<>();
        headers.get(col).setSort();
        sortHeaders.add(headers.get(col));
    }

    public void setSortIcon(int col, STTableHeader header){
    }

    //Build sort list based on columns of sort
    public ArrayList<String> getSorts(){
        ArrayList<String> sorts = new ArrayList<>();
        for(STTableHeader sortHeader : sortHeaders){
            sorts.add(sortHeader.getSortSymbol() + sortHeader.getProperty());
        }
        return sorts;
    }
}
