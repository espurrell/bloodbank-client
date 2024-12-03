package com.keyin.bloodbankclient.model;

import java.time.LocalDate;

public class Person {

    private int id;               // Unique ID for the person
    private String name;          // Person's name
    private String address;       // Address of the person
    private LocalDate dob;        // Date of birth (Changed from Date to LocalDate)
    private String phone;         // Contact phone number
    private String gender;        // Gender
    private String bloodType;     // Blood type (e.g., "A+", "O-")

    // No-argument constructor
    public Person() {}

    // Constructor with all fields
    public Person(int id, String name, String address, LocalDate dob, String phone, String gender, String bloodType) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.phone = phone;
        this.gender = gender;
        this.bloodType = bloodType;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    // Optional: Override toString() for easy display of Person data
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", dob=" + dob +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                ", bloodType='" + bloodType + '\'' +
                '}';
    }
}
