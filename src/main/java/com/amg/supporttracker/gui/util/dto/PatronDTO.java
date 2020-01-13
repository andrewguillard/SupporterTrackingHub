package com.amg.supporttracker.gui.util.dto;

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

    public PatronDTO(){
    }

    public PatronDTO(String patronName, int tierNum, double pledgeAmount, Date pledgeDate){
        this.patronName = patronName;
        this.tierNum = tierNum;
        this.pledgeAmount = pledgeAmount;
        this.pledgeDate = pledgeDate;
    }

    public int getPatronId() {
        return patronId;
    }

    public void setPatronId(int patronId) {
        this.patronId = patronId;
    }

    public String getPatronName() {
        return patronName;
    }

    public void setPatronName(String patronName) {
        this.patronName = patronName;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    public String getDiscordName() {
        return discordName;
    }

    public void setDiscordName(String discordName) {
        this.discordName = discordName;
    }

    public int getTierNum() {
        return tierNum;
    }

    public void setTierNum(int tierNum) {
        this.tierNum = tierNum;
    }

    public double getPledgeAmount() {
        return pledgeAmount;
    }

    public void setPledgeAmount(double pledgeAmount) {
        this.pledgeAmount = pledgeAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getPledgeDate() {
        return pledgeDate;
    }

    public void setPledgeDate(Date pledgeDate) {
        this.pledgeDate = pledgeDate;
    }

    public Date getDeclineDate() {
        return declineDate;
    }

    public void setDeclineDate(Date declineDate) {
        this.declineDate = declineDate;
    }
}
