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

   /* public static void main(String[] args) {
        float floatValue = 123.45f;
        String convertedString = String.valueOf(floatValue);
        String replace = convertedString.replace(".", "");
        String reversedString = String.valueOf(new StringBuilder(replace).reverse());
        String string = new StringBuilder(reversedString).insert(3, ".").toString();
        System.out.println(string);
    }*/

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        System.out.println(numbers);

    }
}
