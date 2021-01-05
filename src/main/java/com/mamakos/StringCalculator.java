package com.mamakos;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public static int add(String numbers) throws Exception {
        if (numbers.equals("")) return 0;

        //figure out whether a custom delimiter is used
        String delimiter = ",";
        if (customDelimiterExists(numbers)) {
            delimiter = numbers.substring(0, 1);
            numbers = numbers.substring(3);
        }

        //prepare error handling
        boolean errorFlag = false;
        StringBuilder errorMsg = new StringBuilder();
        errorMsg.append("Error: Negatives not allowed ");

        //process list
        int total = 0;
        numbers = numbers.replace(System.lineSeparator(), delimiter);
        String[] strArray = numbers.split(delimiter);
        for (String s : strArray) {
            int myInteger = Integer.parseInt(s);
            if (myInteger < 0) {
                errorMsg.append(Integer.parseInt(s));
                errorMsg.append(" ");
                errorFlag = true;
            } else {
                total += myInteger;
            }
        }

        //return results or throw error
        if(errorFlag){
            throw new Exception(errorMsg.toString());
        }
        return total;
    }

    private static boolean customDelimiterExists(String s) {
        String delimiterPattern = "^(\\D)\r\n.*";
        Pattern pattern = Pattern.compile(delimiterPattern);
        Matcher matcher = pattern.matcher(s);
        return matcher.find();
    }
}


