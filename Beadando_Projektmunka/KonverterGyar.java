package org.example;
//Ez a Factory
public class KonverterGyar {

    public static CurrencyConverter getConverter(String currency) {
        CurrencyConverter baseConverter;
        switch (currency) {
            case "EUR":
                baseConverter = new EuroConverter();
                break;
            case "USD":
                baseConverter = new UsdConverter();
                break;
            case "GBP":
                baseConverter = new GbpConverter();
                break;
            case "TRL":
                baseConverter = new TrollisztanConverter();
                break;
            default:
                throw new IllegalArgumentException("Unsupported currency");
        }
        return new FeeDecorator(baseConverter, 0.01);  // minden átváltásból 1% levonás
    }

}