package com.amg.supporttracker.gui.util.dto;

import com.amg.supporttracker.gui.util.STStandard;
import com.amg.supporttracker.gui.util.STUtil;

import java.util.Date;

public class DonationDTO {

    private int donationId;
    private String donationName;
    private String friendlyName;
    private String discordName;
    private double donationAmount;
    private Date donationDate;
    private String source;
    private String status;

    public DonationDTO(){
    }

    public DonationDTO(int id, String name, double donationAmount, Date donationDate){
        this.donationId = id;
        this.donationName = name;
        this.donationAmount = donationAmount;
        this.donationDate = donationDate;
    }

    public int getDonationId() {
        return donationId;
    }

    //Return donationId as a string
    public String getDonationIdString() {
        return String.valueOf(donationId);
    }

    public void setDonationId(int donationId) {
        this.donationId = donationId;
    }
    
    public String getDonationName() {
        return donationName;
    }

    //Return donationName as a string
    public String getDonationNameString() {
        return donationName != null ? donationName : "";
    }

    public void setDonationName(String donationName) {
        this.donationName = donationName;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    //Return friendlyName as a string
    public String getFriendlyNameString() {
        return friendlyName != null ? friendlyName : "";
    }

    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    public String getDiscordName() {
        return discordName;
    }

    //Return discordName as a string
    public String getDiscordNameString() {
        return discordName != null ? discordName : "";
    }

    public void setDiscordName(String discordName) {
        this.discordName = discordName;
    }

    public double getDonationAmount() {
        return donationAmount;
    }

    //Return donationAmount as a string
    public String getDonationAmountString() {
        return String.valueOf(donationAmount);
    }

    public void setDonationAmount(double donationAmount) {
        this.donationAmount = donationAmount;
    }

    public Date getDonationDate() {
        return donationDate;
    }

    //Return donationDate as a string
    public String getDonationDateString() {
        return STUtil.formatDateToString(donationDate, STStandard.TABLE_DATE_FORMAT);
    }

    //Return donationDate as a string for XML
    public String getDonationDateStringXml() {
        return STUtil.formatDateToString(donationDate, STStandard.XML_DATE_FORMAT);
    }

    public void setDonationDate(Date donationDate) {
        this.donationDate = donationDate;
    }

    public String getSource() {
        return source;
    }

    public String getSourceString(){
        return source != null ? source : "undefined";
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getStatus() {
        return status;
    }

    public String getStatusString(){
        return status != null ? status : "undefined";
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
