package Lab01.Q3;

import java.util.Scanner;

public class BinaryMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dec = sc.nextInt();
        String bin = Integer.toBinaryString(dec);
        System.out.println("Number " + String.valueOf(dec) + " in Binary Number: " + bin);
    }
}
