package com.keyin.bloodbankclient.model;

public class Stock {

    private String sBloodType;
    private int quantity;       // Quantity blood units available for blood type

    // No-argument constructor
    public Stock() {}

    // Constructor w/ all fields
    public Stock(String sBloodType, int quantity) {
        this.sBloodType = sBloodType;
        this.quantity = quantity;
    }

    // Getters and Setters
    public String getSBloodType() {
        return sBloodType;
    }

    public void setSBloodType(String sBloodType) {
        this.sBloodType = sBloodType;
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
                "sBloodType='" + sBloodType + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
