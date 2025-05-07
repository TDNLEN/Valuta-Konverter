package org.Projektmunka;

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
    void testFactoryReturnsCorrectConverter() {
        assertTrue(KonverterGyar.getConverter("EUR") instanceof EuroConverter);
        assertTrue(KonverterGyar.getConverter("USD") instanceof UsdConverter);
        assertTrue(KonverterGyar.getConverter("GBP") instanceof GbpConverter);
    }

    @Test
    void testFactoryThrowsOnInvalidCurrency() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            KonverterGyar.getConverter("INVALID");
        });
        assertEquals("Unsupported currency", exception.getMessage());
    }
}

