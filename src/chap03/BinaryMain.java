package chap03;

import java.util.Scanner;
import java.util.ArrayList;

public class BinaryMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dec = sc.nextInt();
        ArrayList<Integer> bin = new ArrayList<>();
        while (dec > 0) {
            bin.add(dec % 2);
            dec /= 2;
        }
        String res = "";
        for(int i: bin) res = res.concat(String.valueOf(i));
        StringBuffer sb = new StringBuffer(res);
        System.out.println(sb.reverse());
    }
}