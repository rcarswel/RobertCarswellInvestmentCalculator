package edu.westga.cs6242.robertcarswellinvestmentcalculator;

import org.junit.Test;

import edu.westga.cs6242.robertcarswellinvestmentcalculator.Model.InvestmentCalculator;

import static org.junit.Assert.assertEquals;

public class InvestmentCalculatorTest {
    private final double RANGE = 0.01;

    @Test
    public void constructorSet() throws Exception {
        InvestmentCalculator investmentCalculator = new InvestmentCalculator(5.00, 0.05, 5);
        assertEquals(0, investmentCalculator.getFutureValue(), RANGE);
    }
}