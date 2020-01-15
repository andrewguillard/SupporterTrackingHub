package com.amg.supporttracker.gui.util.dto;

import com.amg.supporttracker.gui.util.STStandard;
import com.amg.supporttracker.gui.util.STUtil;

import java.util.Date;

public class PatronDTO {

    private int patronId;
    private String patronName;
    private String friendlyName;
    private String discordName;
    private int tierNum;
    private double pledgeAmount;
    private double totalAmount;
    private Date pledgeDate;
    private Date declineDate;
    private String source;

    public PatronDTO(){
    }

    public PatronDTO(int id, String patronName, int tierNum, double pledgeAmount, Date pledgeDate){
        this.patronId = id;
        this.patronName = patronName;
        this.tierNum = tierNum;
        this.pledgeAmount = pledgeAmount;
        this.pledgeDate = pledgeDate;
    }

    public int getPatronId() {
        return patronId;
    }

    //Return patronId as a string
    public String getPatronIdString() {
        return String.valueOf(patronId);
    }

    public void setPatronId(int patronId) {
        this.patronId = patronId;
    }

    public String getPatronName() {
        return patronName;
    }

    //Return patronName as a string
    public String getPatronNameString() {
        return patronName != null ? patronName : "";
    }

    public void setPatronName(String patronName) {
        this.patronName = patronName;
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

    public int getTierNum() {
        return tierNum;
    }

    //Return tierNum as a string
    public String getTierNumString() {
        return String.valueOf(tierNum);
    }

    public void setTierNum(int tierNum) {
        this.tierNum = tierNum;
    }

    public double getPledgeAmount() {
        return pledgeAmount;
    }

    //Return pledgeAmount as a string
    public String getPledgeAmountString() {
        return String.valueOf(pledgeAmount);
    }

    public void setPledgeAmount(double pledgeAmount) {
        this.pledgeAmount = pledgeAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    //Return totalAmount as a string
    public String getTotalAmountString() {
        return String.valueOf(totalAmount);
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getPledgeDate() {
        return pledgeDate;
    }

    //Return pledgeDate as a string
    public String getPledgeDateString() {
        return STUtil.formatDateToString(pledgeDate, STStandard.TABLE_DATE_FORMAT);
    }

    //Return pledgeDate as a string for XML
    public String getPledgeDateStringXml() {
        return STUtil.formatDateToString(pledgeDate, STStandard.XML_DATE_FORMAT);
    }

    public void setPledgeDate(Date pledgeDate) {
        this.pledgeDate = pledgeDate;
    }

    public Date getDeclineDate() {
        return declineDate;
    }

    //Return declineDate as a string
    public String getDeclineDateString() {
        return STUtil.formatDateToString(declineDate, STStandard.TABLE_DATE_FORMAT);
    }

    //Return declineDate as a string for XML
    public String getDeclineDateStringXml() {
        return STUtil.formatDateToString(declineDate, STStandard.XML_DATE_FORMAT);
    }

    public void setDeclineDate(Date declineDate) {
        this.declineDate = declineDate;
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
}
