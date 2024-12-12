package com.employee.managment.Employee.Management.service.serviceImpl;

public class FloatImpl {
    public static void main(String[] args) {
        float fl = 123.32f;
        String str = String.valueOf(fl);
        String[] sp = str.split("\\.");
        String reverse = new StringBuilder(sp[0]).reverse().toString();
        String reverse1 = new StringBuilder(sp[1]).reverse().toString();
        String result = reverse + "." + reverse1;
        System.out.println(result);

    }
}
