package com.amg.supporttracker.gui.util;

import javax.swing.table.JTableHeader;

public class STTableHeader{
    
    private String property;
    private String display;
    private int position;
    private int colSize;
    private String sortSymbol;
    private boolean isEditable;
    
    public STTableHeader(String property, String display){
        this.property = property;
        this.display = display;
        this.isEditable = false;
    }

    public STTableHeader(String property, String display, boolean isEditable){
        this.property = property;
        this.display = display;
        this.isEditable = isEditable;
    }

    public STTableHeader(String property, String display, int position, int size){
        this.property = property;
        this.display = display;
        this.position = position;
        this.colSize = size;
        this.isEditable = false;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getColSize() {
        return colSize;
    }

    public void setColSize(int size) {
        this.colSize = size;
    }

    //Set the sort icon to ascending (true), descending (false), or none (null)
    public void setSortIcon(Boolean isAsc){
        if(isAsc != null) {
            if(isAsc){
                //Show ascending thing
            } else{
                //Show descending thing
            }
        } else{
            //Remove img
        }
    }

    //Toggle the sort
    public void toggleSort(){
        if(sortSymbol == null || !sortSymbol.equals("+")){
            sortSymbol = "+";
        } else{
            sortSymbol = "-";
        }
    }

    //Set the sort symbol to ASC
    public void setSort(){
        sortSymbol = "+";
    }

    public void resetSort(){
        sortSymbol = "";
    }

    public String getSortSymbol(){
        return sortSymbol;
    }

    public boolean isEditable() {
        return isEditable;
    }

    public void setEditable(boolean editable) {
        isEditable = editable;
    }
}
