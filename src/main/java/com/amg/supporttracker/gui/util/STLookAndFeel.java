package com.amg.supporttracker.gui.util;

import java.awt.*;

public class STLookAndFeel {
    
    private String identifier;
    private Color primaryColor;
    private Color secondaryColor;
    private Color backgroundColor;
    private Color highlightColor;
    private Color negativeColor;
    private Color affirmativeColor;
    
    //Patreon Colors
    private Color patreonPrimaryColor;
    private Color patreonSecondaryColor;
    private Color patreonBackgroundColor;
    
    //StreamLabs Colors
    private Color streamlabsPrimaryColor;
    private Color streamlabsSecondaryColor;
    private Color streamlabsBackgroundColor;
    
    //Fonts
    private Font largeFontBold;
    private Font largeFontPlain;
    private Font smallFontBold;
    private Font smallFontPlain;
    
    public STLookAndFeel(String identifier){
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Color getPrimaryColor() {
        return primaryColor;
    }

    public void setPrimaryColor(Color primaryColor) {
        this.primaryColor = primaryColor;
    }

    public Color getSecondaryColor() {
        return secondaryColor;
    }

    public void setSecondaryColor(Color secondaryColor) {
        this.secondaryColor = secondaryColor;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Color getHighlightColor() {
        return highlightColor;
    }

    public void setHighlightColor(Color highlightColor) {
        this.highlightColor = highlightColor;
    }

    public Color getNegativeColor() {
        return negativeColor;
    }

    public void setNegativeColor(Color negativeColor) {
        this.negativeColor = negativeColor;
    }

    public Color getAffirmativeColor() {
        return affirmativeColor;
    }

    public void setAffirmativeColor(Color affirmativeColor) {
        this.affirmativeColor = affirmativeColor;
    }

    public Color getPatreonPrimaryColor() {
        return patreonPrimaryColor;
    }

    public void setPatreonPrimaryColor(Color patreonPrimaryColor) {
        this.patreonPrimaryColor = patreonPrimaryColor;
    }

    public Color getPatreonSecondaryColor() {
        return patreonSecondaryColor;
    }

    public void setPatreonSecondaryColor(Color patreonSecondaryColor) {
        this.patreonSecondaryColor = patreonSecondaryColor;
    }

    public Color getPatreonBackgroundColor() {
        return patreonBackgroundColor;
    }

    public void setPatreonBackgroundColor(Color patreonBackgroundColor) {
        this.patreonBackgroundColor = patreonBackgroundColor;
    }

    public Color getStreamlabsPrimaryColor() {
        return streamlabsPrimaryColor;
    }

    public void setStreamlabsPrimaryColor(Color streamlabsPrimaryColor) {
        this.streamlabsPrimaryColor = streamlabsPrimaryColor;
    }

    public Color getStreamlabsSecondaryColor() {
        return streamlabsSecondaryColor;
    }

    public void setStreamlabsSecondaryColor(Color streamlabsSecondaryColor) {
        this.streamlabsSecondaryColor = streamlabsSecondaryColor;
    }

    public Color getStreamlabsBackgroundColor() {
        return streamlabsBackgroundColor;
    }

    public void setStreamlabsBackgroundColor(Color streamlabsBackgroundColor) {
        this.streamlabsBackgroundColor = streamlabsBackgroundColor;
    }

    public Font getLargeFontBold() {
        return largeFontBold;
    }

    public void setLargeFontBold(Font largeFontBold) {
        this.largeFontBold = largeFontBold;
    }

    public Font getLargeFontPlain() {
        return largeFontPlain;
    }

    public void setLargeFontPlain(Font largeFontPlain) {
        this.largeFontPlain = largeFontPlain;
    }

    public Font getSmallFontBold() {
        return smallFontBold;
    }

    public void setSmallFontBold(Font smallFontBold) {
        this.smallFontBold = smallFontBold;
    }

    public Font getSmallFontPlain() {
        return smallFontPlain;
    }

    public void setSmallFontPlain(Font smallFontPlain) {
        this.smallFontPlain = smallFontPlain;
    }
}
