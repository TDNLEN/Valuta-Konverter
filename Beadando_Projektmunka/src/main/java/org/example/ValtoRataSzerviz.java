package org.example;
//Ez a Singletonunk
class ValtoRataSzerviz {
    private static ValtoRataSzerviz instance;
    private final double euroRate = 380.0;
    private final double usdRate = 350.0;
    private final double gbpRate = 440.0;

    private ValtoRataSzerviz() {}

    public static ValtoRataSzerviz getInstance() {
        if (instance == null) {
            instance = new ValtoRataSzerviz();
        }
        return instance;
    }

    public double getEuroRate() {
        return euroRate;
    }

    public double getUsdRate() {
        return usdRate;
    }

    public double getGbpRate() {
        return gbpRate;
    }
}