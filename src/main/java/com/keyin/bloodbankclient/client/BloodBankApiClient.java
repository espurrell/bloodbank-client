package com.keyin.bloodbankclient.client;

import com.keyin.bloodbankclient.model.Person;

public interface BloodBankApiClient {
    String getAllDonations() throws Exception;
    String getLastHospitalToReceiveStock() throws Exception;
    String getDonationsByPerson(int personId) throws Exception;
    String getDonationsByDate(String date) throws Exception;
    String getDonationsByBloodType(String pBloodType) throws Exception;
    String getAvailableStock(String sBloodType) throws Exception;
    String getStockByBloodType(String sBloodType) throws Exception;
    Person getPersonById(int pId) throws Exception;

    String getPersonById(String personId) throws Exception;

    String createDonation(String donation) throws Exception;

}
