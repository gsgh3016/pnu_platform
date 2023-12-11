package Lab01.Q4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class DateTimeCalculator {
    static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static void main(String[] args) {
        while (true) {
            printMenu();
            selectOption();
        }
    }

    private static void selectOption() {
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        if (option == 1) diff();
        if (option == 2) addNSub();
        if (option == 3) week();
        if (option == 4) {
            System.out.println("Exiting...");
            System.exit(0);
        }
    }

    private static void week() {
        System.out.print("date (YYYY-MM-DD): ");
        LocalDate date = inputDate();
        if (date == null) {
            System.out.println("Invalid date format.");
            return;
        }
        System.out.println("Day of the week: " + date.getDayOfWeek().toString().toUpperCase());
    }

    private static void addNSub() {
        System.out.print("date (YYYY-MM-DD): ");
        LocalDate date = inputDate();
        System.out.print("days to add/subtract: ");
        Scanner sc = new Scanner(System.in);
        int days = sc.nextInt();
        if (date == null) {
            System.out.println("Invalid date format.");
            return;
        }
        LocalDate res = LocalDate.ofEpochDay(date.toEpochDay() + days);
        System.out.println("New date: " + res.format(dateTimeFormatter));
    }

    private static void diff() {
        System.out.print("first date (YYYY-MM-DD): ");
        LocalDate date1 = inputDate();
        System.out.print("second date (YYYY-MM-DD): ");
        LocalDate date2 = inputDate();
        if (date1 == null || date2 == null) {
            System.out.println("Invalid date format.");
            return;
        }
        System.out.printf("Diff: %d days\n", Math.abs(date1.toEpochDay() - date2.toEpochDay()));
    }

    private static LocalDate inputDate() {
        Scanner sc = new Scanner(System.in);
        String dateString = sc.nextLine();
        try {
            return LocalDate.parse(dateString, dateTimeFormatter);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    private static void printMenu() {
        System.out.print("""
                1. Diff
                2. Add/Sub
                3. Week
                4. Exit
                Menu:\s""");
    }
}
