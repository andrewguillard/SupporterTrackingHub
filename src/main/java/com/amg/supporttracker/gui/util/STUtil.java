package com.amg.supporttracker.gui.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class STUtil {
    
    
    
    
    public static void setLookAndFeel() {
        
    }

    public static String formatDateToString(Date date, String format){
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return date != null ? dateFormat.format(date) : "";
    }

    public static Date formatStringToDate(String date, String format){
        if (date.equals("")) { 
            return null; 
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        try{
            return dateFormat.parse(date);
        } catch(ParseException pe){
            System.out.println("Parse to date failed. Returning null.");
            pe.printStackTrace();
            return null;
        }
    }
    
    
}
