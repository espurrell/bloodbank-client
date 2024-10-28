package com.keyin.bloodbankclient.client;

// BloodBankClient.java
public class BloodBankClient {
    private static final String BASE_URL = "http://localhost:8080/api"; // Update with your server’s URL

    public String getAllDonations() throws IOException {
        HttpGet request = new HttpGet(BASE_URL + "/donations");
        try (CloseableHttpClient client = HttpClients.createDefault();
             CloseableHttpResponse response = client.execute(request)) {
            return EntityUtils.toString(response.getEntity());
        }
    }

    // Add other methods as needed
}

