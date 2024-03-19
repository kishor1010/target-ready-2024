import java.util.Scanner;

public class PrintCalendar {
    public static void printCalendar(int month, int year) {
        System.out.println("Su Mo Tu We Th Fr Sa");
        int startDay = calculateStartDay(month,1,year);
        printMonthCalendar(startDay,getDaysInMonth(month,year));

    }
    private static void isValid(int month, int year) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Invalid month. Please enter a month between 1 and 12.");
        } else if (year <= 0) {
            throw new IllegalArgumentException("Invalid year. Please enter a valid year greater than 0.");
        }
    }

    private static int calculateStartDay(int month, int day, int year) {
        if(month < 3) {
            month += 12;
            year--;
        }
        int k = year % 100;
        int j = year / 100;
        int dayOfWeek = (day + 13 * (month + 1) / 5 + k + k / 4 + j / 4 + 5 * j) % 7;

        return (dayOfWeek + 6) % 7;   //converting to 0-based indexing where sunday is 0
    }

    private static int getDaysInMonth(int month, int year) {
        return switch (month) {
            case 2 -> isLeapYear(year) ? 29 : 28;
            case 4, 6, 9, 11 -> 30;
            default -> 31;
        };
    }

    private static boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }

    private static void printMonthCalendar(int startDay, int daysInMonth) {
        int day = 1;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (i == 0 && j < startDay) {
                    System.out.print("   ");
                } else if (day <= daysInMonth) {
                    System.out.printf("%2d ", day);
                    day++;
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the month (1-12): ");
        int month = sc.nextInt();

        System.out.print("Enter the year: ");
        int year = sc.nextInt();

        try {
            isValid(month, year); // Checking validity, exception will be thrown if invalid
            printCalendar(month, year);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
