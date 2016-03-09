package edu.westga.cs6242.robertcarswellinvestmentcalculator;

import org.junit.Test;

import edu.westga.cs6242.robertcarswellinvestmentcalculator.Model.InvestmentCalculator;

import static org.junit.Assert.assertEquals;

public class InvestmentCalculatorTest {
    private static final double RANGE = 0.01;

    @Test
    public void constructorSetTest() throws Exception {
        InvestmentCalculator investmentCalculator = new InvestmentCalculator(1000.00, 0.03, 10);
        assertEquals(11463.88, investmentCalculator.getFutureValue(), RANGE);
    }

    @Test
    public void zeroPeriodicPayment() throws Exception {
        InvestmentCalculator investmentCalculator = new InvestmentCalculator(0, 0.03, 10);
        assertEquals(0, investmentCalculator.getFutureValue(), RANGE);
    }

    @Test
    public void zeroRatePerPeriod() throws Exception {
        InvestmentCalculator investmentCalculator = new InvestmentCalculator(1000, 0, 10);
        assertEquals(10000, investmentCalculator.getFutureValue(), RANGE);
    }

    @Test
    public void zeroPeriod() throws Exception {
        InvestmentCalculator investmentCalculator = new InvestmentCalculator(1000, 0.03, 0);
        assertEquals(0, investmentCalculator.getFutureValue(), RANGE);
    }

    @Test
    public void negativePeriodicPayment() throws Exception {
        InvestmentCalculator investmentCalculator = new InvestmentCalculator(-1000, 0.03, 10);
        assertEquals(-11463.88, investmentCalculator.getFutureValue(), RANGE);
    }

    @Test
    public void negativeRatePerPeriod() throws Exception {
        InvestmentCalculator investmentCalculator = new InvestmentCalculator(1000, -0.03, 10);
        assertEquals(8752.53, investmentCalculator.getFutureValue(), RANGE);
    }

    @Test
    public void negativePeriod() throws Exception {
        InvestmentCalculator investmentCalculator = new InvestmentCalculator(1000, 0.03, -10);
        assertEquals(-8530.20, investmentCalculator.getFutureValue(), RANGE);
    }
}