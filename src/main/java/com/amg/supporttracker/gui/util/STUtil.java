package com.amg.supporttracker.gui.util;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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
}
