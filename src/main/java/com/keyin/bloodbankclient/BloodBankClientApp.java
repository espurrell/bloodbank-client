package com.keyin.bloodbankclient;

import com.keyin.bloodbankclient.client.BloodBankClient;

import java.util.Scanner;

// BloodBankClientApp.java
public class BloodBankClientApp {
    public static void main(String[] args) {
        BloodBankClient client = new BloodBankClient();
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.println("Welcome to Blood Bank Client App");

            while(true) {
                System.out.println("\nSelect an option:");
                System.out.println("1. Get last hospital to recieve stock");
                System.out.println("2. Get donations by person");
                System.out.println("3. Get donations by date");
                System.out.println("4. Get donations by blood type");
                System.out.println("5. Get available stock");
                System.out.println("6. Exit");

                int choice = scanner.nextInt();
                scanner.nextLine();


                switch(choice) {
                    case 1:
                        System.out.println(client.getLastHospitalToRecieveStock());
                        break;
                    case 2:
                        System.out.print("Enter person ID: ");
                        int personId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println(client.getDonationsByPerson(personId));
                        break;
                    case 3:
                        System.out.print("Enter date (yyyy-mm-dd): ");
                        String date = scanner.nextLine();
                        System.out.println(client.getDonationsByDate(date));
                        break;
                    case 4:
                        System.out.print("Enter blood type: ");
                        String bloodType = scanner.nextLine();
                        System.out.println(client.getDonationsByBloodType(bloodType));
                        break;
                    case 5:
                        System.out.print("Enter blood type: ");
                        bloodType = scanner.nextLine();
                        System.out.println(client.getAvailableStock(bloodType));
                        break;
                    case 6:
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice");
                }
            }
        } catch(Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

