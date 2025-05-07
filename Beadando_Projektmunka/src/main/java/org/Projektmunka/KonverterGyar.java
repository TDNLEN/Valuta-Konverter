package org.Projektmunka;
//Ez a Factory

public class KonverterGyar {

    public static CurrencyConverter getConverter(String currency) {
        switch (currency) {
            case "EUR":
                return new EuroConverter();
            case "USD":
                return new UsdConverter();
            case "GBP":
                return new GbpConverter();
            default:
                throw new IllegalArgumentException("Unsupported currency");
        }

    }
}
