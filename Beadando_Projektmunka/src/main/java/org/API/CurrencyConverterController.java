package org.API;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@RestController
public class CurrencyConverterController {


    private static final Map<String, Double> exchangeRates = new HashMap<>();

    static {
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.93);
        exchangeRates.put("HUF", 360.0);
        exchangeRates.put("GBP", 0.80);
    }

    @GetMapping("/convert")
    public double convert(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam double amount) {

        if (!exchangeRates.containsKey(from) || !exchangeRates.containsKey(to)) {
            throw new IllegalArgumentException("Invalid currency code");
        }

        double amountInUsd = amount / exchangeRates.get(from);
        double convertedAmount = amountInUsd * exchangeRates.get(to);

        return convertedAmount;
    }
}
//GET http://localhost:8080/convert?from=USD&to=HUF&amount=100