package com.keyin.bloodbankclient.model;

import java.util.Date;

public class Person {

    private int pId;            // Unique ID for the person
    private String pName;       // Person's name
    private String pAddress;    // Address of the person
    private Date pDob;          // Date of birth
    private String pPhone;      // Contact phone number
    private String pGender;     // Gender
    private String pBloodtype;  // Blood type (e.g., "A+", "O-")

    // No-argument constructor
    public Person() {}

    // Constructor with all fields
    public Person(int pId, String pName, String pAddress, Date pDob, String pPhone, String pGender, String pBloodtype) {
        this.pId = pId;
        this.pName = pName;
        this.pAddress = pAddress;
        this.pDob = pDob;
        this.pPhone = pPhone;
        this.pGender = pGender;
        this.pBloodtype = pBloodtype;
    }

    // Getters and Setters
    public int getPId() {
        return pId;
    }

    public void setPId(int pId) {
        this.pId = pId;
    }

    public String getPName() {
        return pName;
    }

    public void setPName(String pName) {
        this.pName = pName;
    }

    public String getPAddress() {
        return pAddress;
    }

    public void setPAddress(String pAddress) {
        this.pAddress = pAddress;
    }

    public Date getPDob() {
        return pDob;
    }

    public void setPDob(Date pDob) {
        this.pDob = pDob;
    }

    public String getPPhone() {
        return pPhone;
    }

    public void setPPhone(String pPhone) {
        this.pPhone = pPhone;
    }

    public String getPGender() {
        return pGender;
    }

    public void setPGender(String pGender) {
        this.pGender = pGender;
    }

    public String getPBloodtype() {
        return pBloodtype;
    }

    public void setPBloodtype(String pBloodtype) {
        this.pBloodtype = pBloodtype;
    }

    // Optional: Override toString() for easy display of Person data
    @Override
    public String toString() {
        return "Person{" +
                "pId=" + pId +
                ", pName='" + pName + '\'' +
                ", pAddress='" + pAddress + '\'' +
                ", pDob=" + pDob +
                ", pPhone='" + pPhone + '\'' +
                ", pGender='" + pGender + '\'' +
                ", pBloodtype='" + pBloodtype + '\'' +
                '}';
    }
}

