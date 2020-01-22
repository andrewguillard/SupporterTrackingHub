package com.amg.supporttracker.gui.util;

import java.awt.*;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class STUtil {
    
    private STLookAndFeel defaultLF;

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

    //Format currenct DEFAULT = USD
    public static String formatCurrency(Double amount){
        return NumberFormat.getCurrencyInstance().format(amount);
    }

    //Format currency with a locale and a region
    //TODO: Add configurable option for this.
    public static String formatCurrency(String lang, String region, Double amount){
        Locale locale = new Locale(lang, region);
        return NumberFormat.getCurrencyInstance(locale).format(amount);
    }
    
    //Use an object, a variable name, and an addon to get the result of a getter method in the object.
    public static Object invokeGetter(Object obj, String varName, String addon){
        Object value;
        String var = varName + addon;
        try{
            value = new PropertyDescriptor(var, obj.getClass(), "get" + Character.toUpperCase(var.charAt(0)) + var.substring(1), null).getReadMethod().invoke(obj);
            return value;
        } catch (IntrospectionException ie){
            ie.printStackTrace();
        } catch (IllegalAccessException iae){
            iae.printStackTrace();
        } catch(InvocationTargetException ite){
            ite.printStackTrace();
        }
        return null;
    }

    public static Object invokeSetter(Object obj, String varName, String addon, Object setValue){
        Object value;
        String var = varName + addon;
        try{
            value = new PropertyDescriptor(var, obj.getClass(), null, "set" + Character.toUpperCase(var.charAt(0)) + var.substring(1)).getWriteMethod().invoke(obj, setValue);
            return value;
        } catch (IntrospectionException ie){
            ie.printStackTrace();
        } catch (IllegalAccessException iae){
            iae.printStackTrace();
        } catch(InvocationTargetException ite){
            ite.printStackTrace();
        }
        return null;
    }
    
    public static ArrayList<STLookAndFeel> initLookAndFeel(){
        //Create the looks and feels of the app. These might eventually go in an XML.
        ArrayList<STLookAndFeel> looksAndFeels = new ArrayList<>();
        
        //DEFAULT
        STLookAndFeel defaultLF = new STLookAndFeel("DEFAULT");
        defaultLF.setPrimaryColor(new Color(92, 0, 5));
        defaultLF.setSecondaryColor(new Color(255, 255, 255));
        defaultLF.setBackgroundColor(new Color(33, 33, 33));
        defaultLF.setHighlightColor(new Color(164, 235, 225));
        defaultLF.setAffirmativeColor(new Color(201, 93, 93));
        defaultLF.setNegativeColor(new Color(93, 201, 142));
        
        defaultLF.setPatreonPrimaryColor(new Color(240, 118, 84));
        defaultLF.setPatreonSecondaryColor(new Color(255, 255, 255));
        defaultLF.setPatreonBackgroundColor(new Color(30, 32, 48));
        
        defaultLF.setStreamlabsPrimaryColor(new Color(93, 201, 142));
        defaultLF.setStreamlabsSecondaryColor(new Color(255, 255, 255));
        defaultLF.setStreamlabsBackgroundColor(new Color(33, 33, 33));
        
        defaultLF.setLargeFontBold(new Font("TimesRoman", Font.BOLD, 16));
        defaultLF.setLargeFontPlain(new Font("TimesRoman", Font.PLAIN, 16));
        defaultLF.setSmallFontBold(new Font("TimesRoman", Font.BOLD, 12));
        defaultLF.setSmallFontPlain(new Font("TimesRoman", Font.PLAIN, 12));
        
        looksAndFeels.add(defaultLF);
        //LF #2
        
        
        return looksAndFeels;
    }
    
    public static STLookAndFeel getLookAndFeel(ArrayList<STLookAndFeel> lfs, String id){
        for(STLookAndFeel lf : lfs){
            if(lf.getIdentifier().equals(id)){
                return lf;
            }
        }
        return null;
    }
}
