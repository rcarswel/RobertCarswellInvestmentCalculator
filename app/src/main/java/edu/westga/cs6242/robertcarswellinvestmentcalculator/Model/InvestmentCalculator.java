package edu.westga.cs6242.robertcarswellinvestmentcalculator.Model;

public class InvestmentCalculator {
    private double periodicPayment;
    private double ratePerPeriod;
    private int periods;

    public InvestmentCalculator(double periodicPayment, double ratePerPeriod, int periods) {
        this.periodicPayment = periodicPayment;
        this.ratePerPeriod = ratePerPeriod;
        this.periods = periods;
    }

    public double getFutureValue() {
        double futureValue = 0;
        return futureValue;
    }
}
