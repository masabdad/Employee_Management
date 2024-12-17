package com.employee.managment.Employee.Management.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListF {
//    public static void main(String[] args) {
        List<String> listOfCountries = Arrays.asList("Australia", "Sri lanka","Pakistan","Arabia");
        List<String> countriesStartsWithA = listOfCountries.stream()
                .map(String::trim)
                .map(String:: toLowerCase)
                .filter(country -> country.startsWith("a"))
                .distinct()
                .collect(Collectors.toList());

    public static void main(String[] args) {
        float floatValue = 123.45f;
        String convertedString = String.valueOf(floatValue);

        String[] splittedString = convertedString.split("\\.");

        String stringBeforeDecimal = splittedString[0];
        String stringsAfterDecimal =  splittedString[1];
        String reversedStringFirstIndex = new StringBuilder(stringBeforeDecimal).reverse().toString();
        String reversedStringSecondIndex = new StringBuilder(stringsAfterDecimal).reverse().toString();
        String reversedFloat = reversedStringFirstIndex + "." + reversedStringSecondIndex;
        System.out.println(reversedFloat);


    }
}
