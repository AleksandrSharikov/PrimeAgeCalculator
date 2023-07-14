import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inString = "";
        String welcomString = """
                This program should calculate the nearest next year where your age will be a prime number
                Enter the year of your birth. When you are done with this app, type "Exit"
                Years with "-" could be considered as B.C.""";
        int currentYear = LocalDate.now().getYear();
        int birthYear;
        int age;
        System.out.println(welcomString);

        while (!inString.equalsIgnoreCase("Exit")) {
            System.out.println("Enter the year of your birth:");
            inString = scanner.next().trim();
            if (!inString.equalsIgnoreCase("Exit")) {
                try {
                    birthYear = Integer.parseInt(inString.trim());
                    age = currentYear - birthYear;
                    if (age < 0) {
                        System.out.println("You should be already born to use this app");
                        System.out.print("Anyway the answer is ");
                    }
                    if (birthYear < 0) {
                        System.out.println("\"-\" will be considered as B.C.");
                    }
                    System.out.println(birthYear + nearestPrime(age));
                } catch (NumberFormatException e) {
                    System.out.println("Format error. \nPlease, enter your year of birth, or \"Exit\" for exit the app");
                }
            }
        }
    }

    private static int nearestPrime(int beg) {
        boolean isPrime = false;
        int answer = beg;
        int i;
        if (beg <= 0) {
            return 2;
        }
        while (!isPrime) {
            i = 2;
            isPrime = true;
            answer++;
            while (i < answer && isPrime) {
                if (answer % i++ == 0) {
                    isPrime = false;
                }
            }
        }
        return answer;
    }
}