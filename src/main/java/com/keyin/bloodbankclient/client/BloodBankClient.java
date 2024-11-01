package com.keyin.bloodbankclient.client;


import java.io.IOException;
import com.google.gson.Gson;
import com.keyin.bloodbankclient.model.Donation;
import com.keyin.bloodbankclient.model.Person;
import com.keyin.bloodbankclient.model.Stock;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class BloodBankClient implements BloodBankApiClient {
    private static final String BASE_URL = "http://localhost:8080/api"; // Update with your server’s URL

        // Retrieves all donations
        @Override
        public String getAllDonations() throws IOException {
            HttpGet request = new HttpGet(BASE_URL + "/donations");
            try (CloseableHttpClient client = HttpClients.createDefault();
                 CloseableHttpResponse response = client.execute(request)) {
                if (response.getStatusLine().getStatusCode() != 200) {
                    throw new IOException("Failed: HTTP error code : " + response.getStatusLine().getStatusCode());
                }
                return EntityUtils.toString(response.getEntity());
            }
        }

        // Retrieves the last hospital to receive stock
        @Override
        public String getLastHospitalToReceiveStock() throws Exception {
            return sendRequest(BASE_URL + "/receive/lastHospital");
        }

        // Retrieves donations by person ID
        @Override
        public String getDonationsByPerson(int personId) throws Exception {
            return sendRequest(BASE_URL + "/donations/person/" + personId);
        }

        // Retrieves donation count by a specific date
        @Override
        public String getDonationsByDate(String date) throws Exception {
            return sendRequest(BASE_URL + "/donations/countByDate?date=" + date);
        }

        // Retrieves donations by blood type
        @Override
        public String getDonationsByBloodType(String bloodType) throws Exception {
            return sendRequest(BASE_URL + "/donations/countByBloodType?bloodType=" + bloodType);
        }

        // Retrieves available stock for a specific blood type
        @Override
        public String getAvailableStock(String bloodType) throws Exception {
            return sendRequest(BASE_URL + "/stock/bloodType?bloodType=" + bloodType);
        }

    @Override
    public Stock getStockByBloodType(String bloodType) throws Exception {
        return null;
    }

    @Override
    public Person getPersonById(int pId) throws Exception {
        return null;
    }

    @Override
    public Boolean createDonation(Donation donation) throws IOException {
        HttpPost postRequest = new HttpPost(BASE_URL + "/donations");
        Gson gson = new Gson();
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
        private String sendRequest(String endpoint) throws Exception {
            HttpGet request = new HttpGet(endpoint);
            try (CloseableHttpClient client = HttpClients.createDefault();
                 CloseableHttpResponse response = client.execute(request)) {
                if (response.getStatusLine().getStatusCode() != 200) {
                    throw new IOException("Failed: HTTP error code : " + response.getStatusLine().getStatusCode());
                }
                return EntityUtils.toString(response.getEntity());
            }
        }
    }
