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

        // last hospital to recieve stock
        public String getLastHospitalToRecieveStock() throws Exception{
            URL url = new URL(BASE_URL + "/recieve/lastHospital");
            return sendRequest(url);
        }

        // donations by person
        public String getDonationsByPerson(int personId) throws Exception{
            URL url = new URL(BASE_URL + "/donations/person/" + personId);
            return sendRequest(url);
        }

        // donations by date
        public String getDonationsByDate(String date) throws Exception{
            URL url = new URL(BASE_URL + "/donations/countByDate?date=" + date);
            return sendRequest(url);
        }

        // donations by blood type
        public String getDonationsByBloodType(String bloodType) throws Exception{
            URL url = new URL(BASE_URL + "/donations/countByBloodType?bloodType=" + bloodType);
            return sendRequest(url);
        }

        // available stock
        public String getAvailableStock(String bloodType) throws Exception{
            URL url = new URL(BASE_URL + "/stock/bloodType?bloodType=" + bloodType);
            return sendRequest(url);
        }

        // helper method to send request
        private String sendRequest(URL url) throws Exception {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            connection.disconnect();

            return content.toString();
        }
    }

}

