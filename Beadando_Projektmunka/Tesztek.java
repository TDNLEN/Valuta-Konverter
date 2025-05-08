package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Tesztek
{
    private ValtoRataSzerviz exchangeRateService;

    @BeforeEach
    void setUp() {
        exchangeRateService = ValtoRataSzerviz.getInstance();
    }

    @Test
    void testEuroConversion() {
        CurrencyConverter converter = new EuroConverter();
        double huf = 3800;
        double expected = huf / exchangeRateService.getEuroRate();
        double actual = converter.convert(huf);
        assertEquals(expected, actual, 0.001);
    }

    @Test
    void testUsdConversion() {
        CurrencyConverter converter = new UsdConverter();
        double huf = 3500;
        double expected = huf / exchangeRateService.getUsdRate();
        double actual = converter.convert(huf);
        assertEquals(expected, actual, 0.001);
    }

    @Test
    void testGbpConversion() {
        CurrencyConverter converter = new GbpConverter();
        double huf = 4400;
        double expected = huf / exchangeRateService.getGbpRate();
        double actual = converter.convert(huf);
        assertEquals(expected, actual, 0.001);
    }


    @Test
    void testFactoryReturnsFunctionalConverter() {
        double huf = 1000.0;

        CurrencyConverter eur = KonverterGyar.getConverter("EUR");
        double eurExpected = (huf / ValtoRataSzerviz.getInstance().getEuroRate()) * 0.99;
        assertEquals(eurExpected, eur.convert(huf), 0.001);

        CurrencyConverter usd = KonverterGyar.getConverter("USD");
        double usdExpected = (huf / ValtoRataSzerviz.getInstance().getUsdRate()) * 0.99;
        assertEquals(usdExpected, usd.convert(huf), 0.001);

        CurrencyConverter gbp = KonverterGyar.getConverter("GBP");
        double gbpExpected = (huf / ValtoRataSzerviz.getInstance().getGbpRate()) * 0.99;
        assertEquals(gbpExpected, gbp.convert(huf), 0.001);
    }


    @Test
    void testFactoryThrowsOnInvalidCurrency() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            KonverterGyar.getConverter("INVALID");
        });
        assertEquals("Unsupported currency", exception.getMessage());
    }

    @Test
    void testValtoRataSzervizIsSingleton() {
        ValtoRataSzerviz instance1 = ValtoRataSzerviz.getInstance();
        ValtoRataSzerviz instance2 = ValtoRataSzerviz.getInstance();
        assertSame(instance1, instance2, "ValtoRataSzerviz should be singleton");
    }

    @Test
    void testSetEuroRate() {
        double newRate = 400.0;
        exchangeRateService.setEuroRate(newRate);
        assertEquals(newRate, exchangeRateService.getEuroRate(), 0.001);
    }

    @Test
    void testSmallAmountConversion() {
        CurrencyConverter converter = new EuroConverter();
        double huf = 1.0;
        double expected = huf / exchangeRateService.getEuroRate();
        double actual = converter.convert(huf);
        assertEquals(expected, actual, 0.001);
    }
    @Test
    void testTrollisztanConversion() {
        CurrencyConverter converter = new TrollisztanConverter();
        double huf = 1000;
        double expected = huf / exchangeRateService.getTrollisztanRate();
        double actual = converter.convert(huf);
        assertEquals(expected, actual, 0.001);
    }

}


