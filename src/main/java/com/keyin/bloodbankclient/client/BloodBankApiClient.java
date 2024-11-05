package com.keyin.bloodbankclient.client;

import com.keyin.bloodbankclient.model.Donation;
import com.keyin.bloodbankclient.model.Person;
import com.keyin.bloodbankclient.model.Stock;

import java.io.IOException;

public interface BloodBankApiClient {
    String getAllDonations() throws IOException;
    String getLastHospitalToReceiveStock() throws Exception;
    String findDonationsByPersonId(int personId) throws Exception;
    String getDonationsByDate(String date) throws Exception;
    String getDonationsByBloodType(String bloodType) throws Exception;
    String getAvailableStock(String bloodType) throws Exception;
    Stock getStockByBloodType(String bloodType) throws Exception;
    Person getPersonById(int pId) throws IOException;
    Boolean createDonation(Donation donation) throws Exception;
}

