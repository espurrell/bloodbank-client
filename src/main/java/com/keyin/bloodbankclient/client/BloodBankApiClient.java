package com.keyin.bloodbankclient.client;

import com.keyin.bloodbankclient.model.Donation;
import com.keyin.bloodbankclient.model.Person;
import com.keyin.bloodbankclient.model.Stock;

public interface BloodBankApiClient {
    String getAllDonations() throws Exception;
    String getLastHospitalToReceiveStock() throws Exception;
    String getDonationsByPerson(int personId) throws Exception;
    String getDonationsByDate(String date) throws Exception;
    String getDonationsByBloodType(String pBloodType) throws Exception;
    String getAvailableStock(String sBloodType) throws Exception;
    Stock getStockByBloodType(String sBloodType) throws Exception;
    Person getPersonById(int pId) throws Exception;

    String getPersonById(String personId) throws Exception;

    Boolean createDonation(Donation donation) throws Exception;

}
