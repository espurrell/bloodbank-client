package com.keyin.bloodbankclient.model;

public class Stock {

    private String sBloodtype;
    private int quantity;       // Quantity blood units available for blood type

    // No-argument constructor
    public Stock() {}

    // Constructor w/ all fields
    public Stock(String sBloodtype, int quantity) {
        this.sBloodtype = sBloodtype;
        this.quantity = quantity;
    }

    // Getters and Setters
    public String getSBloodtype() {
        return sBloodtype;
    }

    public void setSBloodtype(String sBloodtype) {
        this.sBloodtype = sBloodtype;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Optional: Override toString() for easy display of Stock data
    @Override
    public String toString() {
        return "Stock{" +
                "sBloodtype='" + sBloodtype + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
