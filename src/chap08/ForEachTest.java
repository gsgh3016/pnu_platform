package chap08;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ForEachTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> data = new ArrayList<>();
        data.add(sc.nextInt());
        data.add(sc.nextInt());
        data.add(sc.nextInt());
        data.add(sc.nextInt());
        data.add(sc.nextInt());
        sc.close();
        data.forEach(System.out::println);
        data.forEach(num -> System.out.println(num + 1000));
    }
}
