package com.mamakos;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringCalculatorTest {

    @Test
    public void addSingleDigit() throws Exception {
        assertEquals(0, StringCalculator.add(""));
        assertEquals(100, StringCalculator.add("100"));
    }

    @Test
    public void addDoubleDigit() throws Exception {
        assertEquals(2, StringCalculator.add("1,1"));
        assertEquals(100, StringCalculator.add("99,1"));
    }

    @Test
    public void addUnknownNumberOfDigit() throws Exception {
        assertEquals(3, StringCalculator.add("1,1,1"));
        assertEquals(15, StringCalculator.add("1,1,1,1,1,1,1,1,1,1,1,1,1,1,1"));
    }

    @Test
    public void newLineDelimiter() throws Exception {
        assertEquals(6, StringCalculator.add("1" + System.lineSeparator() + "2,3"));
        assertEquals(6, StringCalculator.add("1,2" + System.lineSeparator() + "3"));
        assertEquals(6, StringCalculator.add("1" + System.lineSeparator() + "2" + System.lineSeparator() + "3"));
    }

    @Test
    public void customDelimiter() throws Exception {
        assertEquals(10, StringCalculator.add(";" + System.lineSeparator() + "1;2;3;4"));
        assertEquals(10, StringCalculator.add("x" + System.lineSeparator() + "1x2x3x4"));
        assertEquals(10, StringCalculator.add("#" + System.lineSeparator() + "1#2" + System.lineSeparator() + "3#4"));
    }

    @Test(expected = Exception.class)
    public void noNegatives() throws Exception {
        StringCalculator.add("-1,-2,4");
    }

}