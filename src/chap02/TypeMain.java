package chap02;

import java.util.Scanner;

public class TypeMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String x = sc.nextLine();
        printType(x);
        int xInt = Integer.parseInt(x);
        printType(xInt);
        float xFloat = Float.parseFloat(x);
        printType(xFloat);
        double xDouble = (double) xFloat;
        printType(xDouble);
    }

    private static void printType(Object x) {
        String printStr = x.toString() + " is a ";
        if (x instanceof String) {
            printStr += "string";
        } else if (x instanceof Integer) {
            printStr += "int";
        } else if (x instanceof Float) {
            printStr += "float";
        } else {
            printStr = "Exception: " + printStr + x.getClass().getName();
        }
        System.out.println(printStr);
    }
}