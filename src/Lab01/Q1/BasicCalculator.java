package Lab01.Q1;

import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- != 0) {
            String[] commands = sc.nextLine().split(" ");
            if (!isValidNumber(commands)) {
                System.out.println("Invalid number format.");
            } else if (!isValidOperator(commands[commands.length - 1])) {
                System.out.println("Invalid operator.");
            } else {
                operate(commands);
            }
        }
    }

    private static void operate(String[] commands) {
        String op = commands[commands.length - 1];
        if (op.equals("sqrt")) {
            System.out.printf("Result: %.2f\n", Math.sqrt(Double.parseDouble(commands[0])));
            return;
        }
        double a = Double.parseDouble(commands[0]);
        double b = Double.parseDouble(commands[1]);
        String result = calculate(op, a, b);
        System.out.println(result);
    }

    private static String calculate(String op, double a, double b) {
        if (op.equals("+")) return String.format("Result: %.2f", a + b);
        if (op.equals("-")) return String.format("Result: %.2f", a - b);
        if (op.equals("*")) return String.format("Result: %.2f", a * b);
        if (op.equals("/")) return b != 0 ? String.format("Result: %.2f", a / b) : "Division by zero";
        if (op.equals("^")) return String.format("Result: %.2f", Math.pow(a, b));
        if (op.equals("%")) return b != 0 ? String.format("Result: %.2f", a % b) : "Division by zero";
        return "Operation Error";
    }


    private static boolean isValidNumber(String[] commands) {
        int size = commands.length;
        for (int i = 0; i < size - 1; i++) {
            try {
                double tmp = Double.parseDouble(commands[i]);
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }
    private static boolean isValidOperator(String operator) {
        return "+".equals(operator) ||
                "-".equals(operator) ||
                "*".equals(operator) ||
                "/".equals(operator) ||
                "sqrt".equals(operator) ||
                "^".equals(operator) ||
                "%".equals(operator);
    }
}