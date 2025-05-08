package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

import java.util.logging.Logger;

public class ExchangeRateFetcher {
    private static final Logger logger = Logger.getLogger(ExchangeRateFetcher.class.getName());

    public static void fetchAndUpdateRates() {
        try {
            String urlStr = "https://api.exchangerate.host/latest?base=HUF&symbols=EUR,USD,GBP";
            logger.info("API hívás indult: " + urlStr);

            URL url = new URL(urlStr);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            con.disconnect();
            System.out.println("API válasz: " + content.toString());

            JSONObject json = new JSONObject(content.toString());
            JSONObject rates = json.getJSONObject("rates");

            ValtoRataSzerviz szerviz = ValtoRataSzerviz.getInstance();
            szerviz.setEuroRate(1 / rates.getDouble("EUR"));
            szerviz.setUsdRate(1 / rates.getDouble("USD"));
            szerviz.setGbpRate(1 / rates.getDouble("GBP"));

            logger.info("Árfolyam frissítés sikeres: EUR=" + szerviz.getEuroRate()
                    + ", USD=" + szerviz.getUsdRate()
                    + ", GBP=" + szerviz.getGbpRate());

        } catch (Exception e) {
            logger.warning("Hiba az árfolyam frissítés közben: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
