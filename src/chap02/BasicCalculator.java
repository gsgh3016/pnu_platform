package chap02;

import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] command = sc.nextLine().split(" ");
            if (command.length == 2 && !command[1].equals("sqrt")) {
                System.out.println("Invalid operator");
            } else if (command.length == 2 && command[1].equals("sqrt")) {
                try {
                    double operand = Double.parseDouble(command[0]);
                    System.out.printf("Result: %.2f\n", Math.sqrt(operand));
                } catch (Exception e) {
                    System.out.println("Invalid number format");
                }
            } else {
                parse2Operands(command);
            }
        }
    }

    private static void parse2Operands(String[] cmd) {
        try {
            double operand1 = Double.parseDouble(cmd[0]);
            double operand2 = Double.parseDouble(cmd[1]);
            double res = 0;
            String operator = cmd[2];
            if (operand2 == 0 && operator.equals("/")) {
                System.out.println("Division by zero");
                return;
            }
            if (operator.equals("+")) res = operand1 + operand2;
            else if (operator.equals("-")) res = operand1 - operand2;
            else if (operator.equals("/")) res = operand1 / operand2;
            else if (operator.equals("*")) res = operand1 * operand2;
            else if (operator.equals("^")) res = Math.pow(operand1, operand2);
            else if (operator.equals("%")) res = operand1 % operand2;
            System.out.printf("Result: %.2f\n", res);
        } catch (Exception e) {
            System.out.println("Invalid number format");
        }
    }
}