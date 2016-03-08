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

}