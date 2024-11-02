package com.keyin.bloodbankclient.model;

import java.util.Date;

public class Receive {

    private int r_id;           // Unique ID for the receive record
    private Date r_date;        // Date blood was received
    private int p_id;           // ID of the person receiving the blood
    private int quantity;      // Quantity of blood units received
    private String r_hospital;  // Hospital name where blood was received

    // No-argument constructor
    public Receive() {}

    // Constructor with all fields
    public Receive(int r_id, Date r_date, int p_id, int quantity, String r_hospital) {
        this.r_id = r_id;
        this.r_date = r_date;
        this.p_id = p_id;
        this.quantity = quantity;
        this.r_hospital = r_hospital;
    }

    // Getters and Setters
    public int getRId() {
        return r_id;
    }

    public void setRId(int r_id) {
        this.r_id = r_id;
    }

    public Date getRDate() {
        return r_date;
    }

    public void setRDate(Date r_date) {
        this.r_date = r_date;
    }

    public int getPId() {
        return p_id;
    }

    public void setPId(int p_id) {
        this.p_id = p_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getRHospital() {
        return r_hospital;
    }

    public void setRHospital(String r_hospital) {
        this.r_hospital = r_hospital;
    }

    // Optional: Override toString() for easy display of Receive data
    @Override
    public String toString() {
        return "Receive{" +
                "r_id=" + r_id +
                ", r_date=" + r_date +
                ", p_id=" + p_id +
                ", quantity=" + quantity +
                ", r_hospital='" + r_hospital + '\'' +
                '}';
    }
}
