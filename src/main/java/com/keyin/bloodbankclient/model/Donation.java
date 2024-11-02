package com.keyin.bloodbankclient.model;

import java.util.Date;

public class Donation {

    private int d_id;           // Donation ID
    private Date d_date;        // Donation date
    private String d_time;      // Donation time
    private int p_id;           // Person ID of the donor
    private int quantity;      // Quantity of blood donated

    // No-argument constructor
    public Donation() {}

    // Constructor with all fields
    public Donation(int dId, Date dDate, String dTime, int pId, int quantity) {
        this.d_id = dId;
        this.d_date = dDate;
        this.d_time = dTime;
        this.p_id = pId;
        this.quantity = quantity;
    }

    // Getters and Setters
    public int getDId() {
        return d_id;
    }

    public void setDId(int dId) {
        this.d_id = dId;
    }

    public Date getDDate() {
        return d_date;
    }

    public void setDDate(Date dDate) {
        this.d_date = dDate;
    }

    public String getDTime() {
        return d_time;
    }

    public void setDTime(String dTime) {
        this.d_time = dTime;
    }

    public int getPId() {
        return p_id;
    }

    public void setPId(int pId) {
        this.p_id = pId;
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
                "dId=" + d_id +
                ", dDate=" + d_date +
                ", dTime='" + d_time + '\'' +
                ", pId=" + p_id +
                ", quantity=" + quantity +
                '}';
    }
}
