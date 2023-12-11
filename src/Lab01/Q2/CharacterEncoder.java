package Lab01.Q2;

import java.util.Scanner;

public class CharacterEncoder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String target = sc.nextLine();
        StringBuilder encoded = new StringBuilder();
        int n = sc.nextInt();
        for (char c: target.toCharArray()) {
            if (!Character.isLetter(c)) {
                System.out.println("The string contains characters that cannot be encoded.");
                return;
            } else if (Character.isUpperCase(c)) {
                encoded.append((char) ((c - 'A' + n) % 26 + 'A'));
            } else {
                encoded.append((char) ((c - 'a' + n) % 26 + 'a'));
            }
        }
        System.out.println(encoded);
    }
}
