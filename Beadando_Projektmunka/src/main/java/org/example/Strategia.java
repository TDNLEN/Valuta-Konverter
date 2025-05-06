package org.example;

class EuroConverter implements CurrencyConverter {
    @Override
    public double convert(double hufAmount) {
        return hufAmount / ValtoRataSzerviz.getInstance().getEuroRate();
    }
}

class UsdConverter implements CurrencyConverter {
    @Override
    public double convert(double hufAmount) {
        return hufAmount / ValtoRataSzerviz.getInstance().getUsdRate();
    }
}

class GbpConverter implements CurrencyConverter {
    @Override
    public double convert(double hufAmount) {
        return hufAmount / ValtoRataSzerviz.getInstance().getGbpRate();
    }
}
