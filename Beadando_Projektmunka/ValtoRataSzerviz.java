package org.example;
//Ez a Singletonunk
class ValtoRataSzerviz {
    private static ValtoRataSzerviz instance;
    private double euroRate = 380.0;
    private double usdRate = 350.0;
    private double gbpRate = 440.0;

    private ValtoRataSzerviz() {}

    public static ValtoRataSzerviz getInstance() {
        if (instance == null) {
            instance = new ValtoRataSzerviz();
        }
        return instance;
    }

    private double trollisztanRate = 100.0;  // Például 100 HUF = 1 TRL

    public double getTrollisztanRate() {
        return trollisztanRate;
    }

    public void setTrollisztanRate(double trollisztanRate) {
        this.trollisztanRate = trollisztanRate;
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

    public void setEuroRate(double euroRate) {
        this.euroRate = euroRate;
    }

    public void setUsdRate(double usdRate) {
        this.usdRate = usdRate;
    }

    public void setGbpRate(double gbpRate) {
        this.gbpRate = gbpRate;
    }

}

