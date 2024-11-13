package pedrao;

import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URI;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class CurrencyApi {


    public static String sendGetRequest(String urlString) throws Exception {

        URI uri = new URI(urlString);
        URL url = uri.toURL();
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder responseContent = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            responseContent.append(inputLine);
        }
        in.close();
        return responseContent.toString();
    }

    public static Map<String, Double> parseExchangeRates(String response) {
        Map<String, Double> exchangeRates = new HashMap<>();
        JSONObject jsonResponse = new JSONObject(response);
        JSONObject rates = jsonResponse.getJSONObject("data");

        for (String key : rates.keySet()) {
            exchangeRates.put(key.toLowerCase(), rates.getDouble(key));
        }

        return exchangeRates;
    }
}