package org.example;

public class ExchangeRateFetcherProxy {
    private boolean hasFetched = false;

    public void fetchAndUpdateRates() {
        if (!hasFetched) {
            ExchangeRateFetcher.fetchAndUpdateRates();
            hasFetched = true;
        } else {
            System.out.println("Cache-ből szolgáltatott árfolyam.");
        }
    }
}
