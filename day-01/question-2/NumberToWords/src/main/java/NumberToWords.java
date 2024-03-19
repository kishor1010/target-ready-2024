import java.util.Scanner;

public class NumberToWords {
    public static String inWords(int num) {
        String[] units = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] teens = {"", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

        if (num == 0) {
            return "zero";
        }

        String result = "";

        if (num >= 10000000) {
            result += convertToWords(num / 10000000) + " crore ";
            num %= 10000000;
        }

        if (num >= 100000) {
            result += convertToWords(num / 100000) + " lakh ";
            num %= 100000;
        }

        if (num >= 1000) {
            result += convertToWords(num / 1000) + " thousand ";
            num %= 1000;
        }

        if (num >= 100) {
            result += convertToWords(num / 100) + " hundred ";
            num %= 100;
        }


        if (num > 0) {
            if (num < 10) {
                result += units[num];
            } else if (num < 20) {
                result += teens[num - 10];
            } else {
                result += tens[num / 10];
                if (num % 10 != 0) {
                    result += " " + units[num % 10];
                }
            }
        }
        return result.trim();
    }

    private static String convertToWords(int num) {
        String result = "";
        if (num >= 100) {
            result += units[num / 100] + " hundred";
            num %= 100;
            if (num != 0) {
                result += " ";
            }
        }
        if (num >= 20) {
            result += tens[num / 10];
            if (num % 10 != 0) {
                result += " " + units[num % 10];
            }
        } else if (num > 0) {
            result += units[num];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new sc(System.in);
        int num;
        char choice;
        do {
            System.out.print("Enter a number between 1 and 99,99,99,999: ");
            num = sc.nextInt();
            sc.nextLine(); // Consume newline
            System.out.println(num + " in words: " + inWords(num));
            System.out.print("Do you want to continue (Y/N)? ");
            choice = sc.nextLine().charAt(0);
        } while (Character.toUpperCase(choice) == 'Y');
        sc.close();
        System.out.println("Goodbye! See you again...");
    }
}
