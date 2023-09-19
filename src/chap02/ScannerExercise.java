package chap02;

import java.util.Scanner;

public class ScannerExercise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println(a);
        boolean b = sc.nextBoolean();
        System.out.println(b);
        byte c = sc.nextByte();
        System.out.println(c);
        float d = sc.nextFloat();
        System.out.println(d);
        double e = sc.nextDouble();
        System.out.println(e);
        String f = sc.nextLine();
        System.out.println(f);
    }
}