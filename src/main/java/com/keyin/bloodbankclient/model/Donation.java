package com.keyin.bloodbankclient.model;

import java.util.Date;

public class Donation {

    private int dId;           // Donation ID
    private Date dDate;        // Donation date
    private String dTime;      // Donation time
    private int pId;           // Person ID of the donor
    private int quantity;      // Quantity of blood donated

    // No-argument constructor
    public Donation() {}

    // Constructor with all fields
    public Donation(int dId, Date dDate, String dTime, int pId, int quantity) {
        this.dId = dId;
        this.dDate = dDate;
        this.dTime = dTime;
        this.pId = pId;
        this.quantity = quantity;
    }

    // Getters and Setters
    public int getDId() {
        return dId;
    }

    public void setDId(int dId) {
        this.dId = dId;
    }

    public Date getDDate() {
        return dDate;
    }

    public void setDDate(Date dDate) {
        this.dDate = dDate;
    }

    public String getDTime() {
        return dTime;
    }

    public void setDTime(String dTime) {
        this.dTime = dTime;
    }

    public int getPId() {
        return pId;
    }

    public void setPId(int pId) {
        this.pId = pId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    @Override
    public String toString() {
        return "Donation{" +
                "dId=" + dId +
                ", dDate=" + dDate +
                ", dTime='" + dTime + '\'' +
                ", pId=" + pId +
                ", quantity=" + quantity +
                '}';
    }
}
