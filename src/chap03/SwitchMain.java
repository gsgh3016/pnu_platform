package chap03;

import java.util.Scanner;
import java.time.Month;
import java.util.LinkedList;
import java.util.Queue;

public class SwitchMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Month> s = new LinkedList<>();

        while (true) {
            String[] cmd = sc.nextLine().split(" ");
            if (cmd.length == 1 && cmd[0].equalsIgnoreCase("quit")) {
                System.out.println("Bye");
                break;
            } else if (cmd.length == 1 && cmd[0].equalsIgnoreCase("print")) {
                while (!s.isEmpty()) {
                    String monName = s.poll().name().toLowerCase();
                    monName = monName.substring(0, 1).toUpperCase() + monName.substring(1);
                    System.out.println(monName);
                }
            } else if (cmd.length == 2 && cmd[0].equalsIgnoreCase("add")) {
                s.add(Month.of(Integer.parseInt(cmd[1])));
            } else {
                System.out.println("Invalid command");
            }
        }
    }
}