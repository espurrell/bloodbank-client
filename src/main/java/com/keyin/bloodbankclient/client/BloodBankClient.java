package com.keyin.bloodbankclient.client;

import com.google.gson.Gson;
import com.keyin.bloodbankclient.model.Donation;
import com.keyin.bloodbankclient.model.Person;
import com.keyin.bloodbankclient.model.Stock;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.http.client.ClientProtocolException;
import java.io.IOException;

public class BloodBankClient implements BloodBankApiClient {
    private static final String BASE_URL = "http://localhost:8080";
    private final Gson gson = new Gson();

    // Retrieves all donations
    @Override
    public String getAllDonations() {
        try {
            return sendGetRequest(BASE_URL + "/donations");
        } catch (IOException e) {
            throw new RuntimeException("Error retrieving donations: " + e.getMessage(), e);
        }
    }

    // Retrieves the last hospital to receive stock
    @Override
    public String getLastHospitalToReceiveStock() {
        try {
            return sendGetRequest(BASE_URL + "/receive/lastHospital");
        } catch (IOException e) {
            throw new RuntimeException("Error retrieving last hospital: " + e.getMessage(), e);
        }
    }

    // Retrieves donations by person ID
    @Override
    public String findDonationsByPersonId(int personId) {
        try {
            return sendGetRequest(BASE_URL + "/donations/person/" + personId);
        } catch (IOException e) {
            throw new RuntimeException("Error retrieving donations for person ID " + personId + ": " + e.getMessage(), e);
        }
    }

    // Retrieves donation count by a specific date
    @Override
    public String getDonationsByDate(String date) {
        try {
            return sendGetRequest(BASE_URL + "/donations/countByDate?date=" + date);
        } catch (IOException e) {
            throw new RuntimeException("Error retrieving donations by date: " + e.getMessage(), e);
        }
    }

    // Retrieves donations by blood type
    @Override
    public String getDonationsByBloodType(String bloodType) {
        try {
            return sendGetRequest(BASE_URL + "/donations/countByBloodType?bloodType=" + bloodType);
        } catch (IOException e) {
            throw new RuntimeException("Error retrieving donations by blood type: " + e.getMessage(), e);
        }
    }

    // Retrieves available stock for a specific blood type
    @Override
    public String getAvailableStock(String bloodType) {
        try {
            return sendGetRequest(BASE_URL + "/stock/bloodType?bloodType=" + bloodType);
        } catch (IOException e) {
            throw new RuntimeException("Error retrieving available stock: " + e.getMessage(), e);
        }
    }

    // Retrieves stock information by blood type
    @Override
    public Stock getStockByBloodType(String bloodType) {
        String response = getAvailableStock(bloodType);
        return gson.fromJson(response, Stock.class);
    }

    // Retrieves person information by ID
    @Override
    public Person getPersonById(int pId) {
        try {
            String response = sendGetRequest(BASE_URL + "/person/" + pId);
            return gson.fromJson(response, Person.class);
        } catch (IOException e) {
            throw new RuntimeException("Error retrieving person by ID: " + e.getMessage(), e);
        }
    }

    // Creates a new donation
    @Override
    public Boolean createDonation(Donation donation) {
        HttpPost postRequest = new HttpPost(BASE_URL + "/donations");

        // Serialize the Donation object to JSON
        String json = gson.toJson(donation);

        postRequest.setEntity(new StringEntity(json, "UTF-8"));
        postRequest.setHeader("Content-type", "application/json");

        try (CloseableHttpClient client = HttpClients.createDefault();
             CloseableHttpResponse response = client.execute(postRequest)) {
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 201) { // Assuming 201 Created for successful POST
                return true;
            } else {
                // Include the response body in the error message for more context
                String responseBody = EntityUtils.toString(response.getEntity());
                throw new RuntimeException("Failed: HTTP error code: " + statusCode + ", Response: " + responseBody);
            }
        } catch (ClientProtocolException e) {
            throw new RuntimeException("Client protocol error: " + e.getMessage(), e);
        } catch (IOException e) {
            throw new RuntimeException("Error creating donation: " + e.getMessage(), e);
        }
    }


    // Helper method to send an HTTP GET request and return the response as a string
    private String sendGetRequest(String endpoint) throws IOException {
        HttpGet request = new HttpGet(endpoint);
        try (CloseableHttpClient client = HttpClients.createDefault();
             CloseableHttpResponse response = client.execute(request)) {
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed: HTTP error code: " + statusCode);
            }
            return EntityUtils.toString(response.getEntity());
        }
    }
}
