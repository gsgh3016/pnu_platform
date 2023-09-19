package chap02;

public class StringCompareMain {
    public static void main(String[] args) {
        String str1 = "java is easy";
        String str2 = "JAVA IS EASY";
        String str3 = "java is fun";

        System.out.println(str1.equals(str2));
        System.out.println(str1.equals(str2.toLowerCase()));
        System.out.println(str1.equalsIgnoreCase(str2));
        System.out.println(str1.equals(str3.replaceAll("fun", "easy")));
    }
}