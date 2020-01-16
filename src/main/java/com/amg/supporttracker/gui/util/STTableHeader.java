package com.amg.supporttracker.gui.util;

public class STTableHeader {
    
    private String property;
    private String display;
    private int position;
    private int size;
    
    public STTableHeader(String property, String display){
        this.property = property;
        this.display = display;
    }

    public STTableHeader(String property, String display, int position, int size){
        this.property = property;
        this.display = display;
        this.position = position;
        this.size = size;
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
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
}
