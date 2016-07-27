package com.madebyatomicrobot.testingpresentation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    private Calculator calculator;

    // This is called before every method in this class annotated with @Test
    @Before
    public void setup() {
        calculator = new Calculator();
    }

    // Methods annotated with @Test indicate that this is a method JUnit should execute
    @Test
    public void testAddZeros() throws Exception {
        // Assertions should contain the expected value on the left, actual value on the right
        assertEquals(0, calculator.add(0, 0));
    }

    @Test
    public void testAddPositiveIntegers() throws Exception {
        assertEquals(2, calculator.add(1, 1));
    }

    @Test
    public void testAddNegativeIntegers() throws Exception {
        assertEquals(-2, calculator.add(-1, -1));
    }
}