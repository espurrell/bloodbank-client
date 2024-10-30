package com.keyin.bloodbankclient.model;

import java.util.Date;

public class Receive {

    private int rId;           // Unique ID for the receive record
    private Date rDate;        // Date blood was received
    private int pId;           // ID of the person receiving the blood
    private int quantity;      // Quantity of blood units received
    private String rHospital;  // Hospital name where blood was received

    // No-argument constructor
    public Receive() {}

    // Constructor with all fields
    public Receive(int rId, Date rDate, int pId, int quantity, String rHospital) {
        this.rId = rId;
        this.rDate = rDate;
        this.pId = pId;
        this.quantity = quantity;
        this.rHospital = rHospital;
    }

    // Getters and Setters
    public int getRId() {
        return rId;
    }

    public void setRId(int rId) {
        this.rId = rId;
    }

    public Date getRDate() {
        return rDate;
    }

    public void setRDate(Date rDate) {
        this.rDate = rDate;
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

    public String getRHospital() {
        return rHospital;
    }

    public void setRHospital(String rHospital) {
        this.rHospital = rHospital;
    }

    // Optional: Override toString() for easy display of Receive data
    @Override
    public String toString() {
        return "Receive{" +
                "rId=" + rId +
                ", rDate=" + rDate +
                ", pId=" + pId +
                ", quantity=" + quantity +
                ", rHospital='" + rHospital + '\'' +
                '}';
    }
}
