package com.keyin.bloodbankclient.model;

import java.util.Date;

public class Person {

    private int p_id;            // Unique ID for the person
    private String p_name;       // Person's name
    private String p_address;    // Address of the person
    private Date p_dob;          // Date of birth
    private String p_phone;      // Contact phone number
    private String p_gender;     // Gender
    private String p_bloodtype;  // Blood type (e.g., "A+", "O-")

    // No-argument constructor
    public Person() {}

    // Constructor with all fields
    public Person(int pId, String pName, String pAddress, Date pDob, String pPhone, String pGender, String pBloodtype) {
        this.p_id = pId;
        this.p_name = pName;
        this.p_address = pAddress;
        this.p_dob = pDob;
        this.p_phone = pPhone;
        this.p_gender = pGender;
        this.p_bloodtype = pBloodtype;
    }

    // Getters and Setters
    public int getPId() {
        return p_id;
    }

    public void setPId(int pId) {
        this.p_id = pId;
    }

    public String getPName() {
        return p_name;
    }

    public void setPName(String pName) {
        this.p_name = pName;
    }

    public String getPAddress() {
        return p_address;
    }

    public void setPAddress(String pAddress) {
        this.p_address = pAddress;
    }

    public Date getPDob() {
        return p_dob;
    }

    public void setPDob(Date pDob) {
        this.p_dob = pDob;
    }

    public String getPPhone() {
        return p_phone;
    }

    public void setPPhone(String pPhone) {
        this.p_phone = pPhone;
    }

    public String getPGender() {
        return p_gender;
    }

    public void setPGender(String pGender) {
        this.p_gender = pGender;
    }

    public String getPBloodType() {
        return p_bloodtype;
    }

    public void setPBloodType(String p_bloodType) {
        this.p_bloodtype = p_bloodtype;
    }

    // Optional: Override toString() for easy display of Person data
    @Override
    public String toString() {
        return "Person{" +
                "pId=" + p_id +
                ", pName='" + p_name + '\'' +
                ", pAddress='" + p_address + '\'' +
                ", pDob=" + p_dob +
                ", pPhone='" + p_phone + '\'' +
                ", pGender='" + p_gender + '\'' +
                ", pBloodType='" + p_bloodtype + '\'' +
                '}';
    }
}

