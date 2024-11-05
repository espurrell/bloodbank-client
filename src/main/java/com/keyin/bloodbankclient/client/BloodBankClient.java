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
    private static final String BASE_URL = "http://localhost:8080"; // Update with your server’s URL
    private final Gson gson = new Gson();

    // Retrieves all donations
    @Override
    public String getAllDonations() throws IOException {
        return sendGetRequest(BASE_URL + "/donations");
    }

    // Retrieves the last hospital to receive stock
    @Override
    public String getLastHospitalToReceiveStock() throws IOException {
        return sendGetRequest(BASE_URL + "/receive/lastHospital");
    }

    // Retrieves donations by person ID
    @Override
    public String findDonationsByPersonId(int personId) throws IOException {
        return sendGetRequest(BASE_URL + "/donations/person/" + personId);
    }

    // Retrieves donation count by a specific date
    @Override
    public String getDonationsByDate(String date) throws IOException {
        return sendGetRequest(BASE_URL + "/donations/countByDate?date=" + date);
    }

    // Retrieves donations by blood type
    @Override
    public String getDonationsByBloodType(String bloodType) throws IOException {
        return sendGetRequest(BASE_URL + "/donations/countByBloodType?bloodType=" + bloodType);
    }

    // Retrieves available stock for a specific blood type
    @Override
    public String getAvailableStock(String bloodType) throws IOException {
        return sendGetRequest(BASE_URL + "/stock/bloodType?bloodType=" + bloodType);
    }

    // Retrieves stock information by blood type (placeholder implementation)
    @Override
    public Stock getStockByBloodType(String bloodType) throws IOException {
        String response = getAvailableStock(bloodType);
        return gson.fromJson(response, Stock.class); // Assuming Stock class matches JSON structure
    }

    // Retrieves person information by ID (placeholder implementation)
    @Override
    public Person getPersonById(int pId) throws IOException {
        String response = sendGetRequest(BASE_URL + "/person/" + pId);
        return gson.fromJson(response, Person.class); // Assuming Person class matches JSON structure
    }

    // Creates a new donation
    @Override
    public Boolean createDonation(Donation donation) throws IOException {
        HttpPost postRequest = new HttpPost(BASE_URL + "/donations");
        String json = gson.toJson(donation);

        postRequest.setEntity(new StringEntity(json));
        postRequest.setHeader("Content-type", "application/json");

        try (CloseableHttpClient client = HttpClients.createDefault();
             CloseableHttpResponse response = client.execute(postRequest)) {
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 201) { // Assuming 201 Created for successful POST
                return true;
            } else {
                throw new ClientProtocolException("Failed: HTTP error code : " + statusCode);
            }
        }
    }

    // Helper method to send an HTTP GET request and return the response as a string
    private String sendGetRequest(String endpoint) throws IOException {
        HttpGet request = new HttpGet(endpoint);
        try (CloseableHttpClient client = HttpClients.createDefault();
             CloseableHttpResponse response = client.execute(request)) {
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new IOException("Failed: HTTP error code : " + statusCode);
            }
            return EntityUtils.toString(response.getEntity());
        }
    }
}