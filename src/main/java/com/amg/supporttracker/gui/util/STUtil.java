package com.amg.supporttracker.gui.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class STUtil {
    
    
    
    
    public static void setLookAndFeel() {
        
    }

    public static String formatDate(Date date, String format){
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return date != null ? dateFormat.format(date) : "";
    }
    
    
}
