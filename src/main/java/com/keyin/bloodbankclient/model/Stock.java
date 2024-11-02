package com.keyin.bloodbankclient.model;

public class Stock {

    private String s_bloodtype;
    private int quantity;       // Quantity blood units available for blood type

    // No-argument constructor
    public Stock() {}

    // Constructor w/ all fields
    public Stock(String s_bloodtype, int quantity) {
        this.s_bloodtype = s_bloodtype;
        this.quantity = quantity;
    }

    // Getters and Setters
    public String getSBloodType() {
        return s_bloodtype;
    }

    public void setSBloodType(String s_bloodtype) {
        this.s_bloodtype = s_bloodtype;
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
                "s_bloodtype='" + s_bloodtype + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
