package chap04;

import java.util.Scanner;
import java.lang.reflect.*;

public class ReflectionTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String arg1 = sc.next();
        Double arg2 = sc.nextDouble();
        sc.close();

        String className = "chap04.Employee";
        Class[] cArgs = new Class[2];
        cArgs[0] = String.class;
        cArgs[1] = Double.class;

        Employee employee1 = null;
        try {
            employee1 = (Employee) Class.forName(className).getConstructor(cArgs).newInstance(arg1, arg2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(employee1);
    }
}