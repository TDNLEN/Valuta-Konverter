package org.example;

class FeeDecorator implements CurrencyConverter {
    private final CurrencyConverter decorated;
    private final double fee;  // pl. 1%

    public FeeDecorator(CurrencyConverter decorated, double fee) {
        this.decorated = decorated;
        this.fee = fee;
    }

    @Override
    public double convert(double hufAmount) {
        double base = decorated.convert(hufAmount);
        return base - (base * fee);  // levonja a díjat
    }
}
