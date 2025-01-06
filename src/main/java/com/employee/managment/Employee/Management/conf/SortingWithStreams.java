package com.employee.managment.Employee.Management.conf;

import java.util.Comparator;
import java.util.List;

public class SortingWithStreams {
    public static void main(String[] args) {
        List<String> integerValues = List.of("1","2","2","3","4","5","6");
        List<String> list = integerValues.stream()
                .sorted(Comparator.reverseOrder())
                .distinct()
                .toList();
        System.out.println(list);
    }
}
