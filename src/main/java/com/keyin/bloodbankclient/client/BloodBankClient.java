package com.keyin.bloodbankclient.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class BloodBankClient {
    private static final String BASE_URL = "http://localhost:8080/api"; // Update with your server’s URL

    // Retrieves all donations
    public String getAllDonations() throws IOException {
        HttpGet request = new HttpGet(BASE_URL + "/donations");
        try (CloseableHttpClient client = HttpClients.createDefault();
             CloseableHttpResponse response = client.execute(request)) {
            return EntityUtils.toString(response.getEntity());
        }
    }

    // Retrieves the last hospital to receive stock
    public String getLastHospitalToReceiveStock() throws Exception {
        URL url = new URL(BASE_URL + "/receive/lastHospital");
        return sendRequest(url);
    }

    // Retrieves donations by person ID
    public String getDonationsByPerson(int personId) throws Exception {
        URL url = new URL(BASE_URL + "/donations/person/" + personId);
        return sendRequest(url);
    }

    // Retrieves donation count by a specific date
    public String getDonationsByDate(String date) throws Exception {
        URL url = new URL(BASE_URL + "/donations/countByDate?date=" + date);
        return sendRequest(url);
    }

    // Retrieves donations by blood type
    public String getDonationsByBloodType(String bloodType) throws Exception {
        URL url = new URL(BASE_URL + "/donations/countByBloodType?bloodType=" + bloodType);
        return sendRequest(url);
    }

    // Retrieves available stock for a specific blood type
    public String getAvailableStock(String bloodType) throws Exception {
        URL url = new URL(BASE_URL + "/stock/bloodType?bloodType=" + bloodType);
        return sendRequest(url);
    }

    // Helper method to send an HTTP GET request and return the response as a string
    private String sendRequest(URL url) throws Exception {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            StringBuilder content = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            return content.toString();
        } finally {
            connection.disconnect();
        }
    }
}
