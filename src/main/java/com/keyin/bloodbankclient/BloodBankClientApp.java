package com.keyin.bloodbankclient;

import com.keyin.bloodbankclient.client.BloodBankClient;

import java.util.Scanner;

// BloodBankClientApp.java
public class BloodBankClientApp {
    public static void main(String[] args) {
        BloodBankClient client = new BloodBankClient();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Blood Bank Client");

        System.out.println("1. Show all donations");
        System.out.println("2. Check stock by blood type");
        System.out.print("Choose an option: ");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println(client.getAllDonations());
                break;
            case 2:
                // Implement other options
                break;
        }
    }
}

