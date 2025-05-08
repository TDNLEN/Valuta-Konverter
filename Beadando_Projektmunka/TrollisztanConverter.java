package org.example;


class TrollisztanConverter implements CurrencyConverter {
    @Override
    public double convert(double hufAmount) {
        return hufAmount / ValtoRataSzerviz.getInstance().getTrollisztanRate();
    }
}
