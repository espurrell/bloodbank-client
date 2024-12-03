package com.keyin.bloodbankclient.model;

public class Stock {

    private Long s_id;          // Primary Key
    private String s_bloodtype; // Blood type
    private int quantity;       // Quantity of blood in stock

    // No-argument constructor
    public Stock() {}

    // Constructor with all fields
    public Stock(Long s_id, String s_bloodtype, int quantity) {
        this.s_id = s_id;
        this.s_bloodtype = s_bloodtype;
        this.quantity = quantity;
    }

    // Getters and Setters
    public Long getSId() {
        return s_id;
    }

    public void setSId(Long s_id) {
        this.s_id = s_id;
    }

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
                "s_id=" + s_id +
                ", s_bloodtype='" + s_bloodtype + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
