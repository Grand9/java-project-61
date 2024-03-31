package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                Cli.welcomeUser();
                break;
            case 0:
                System.out.println("Goodbye!");
                break;
            case 2:
                Games.startEvenGame(scanner);
                break;
            case 3:
                Games.calculator(scanner);
                break;
            case 4:
                Games.gcd(scanner);
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid game number.");
                break;
        }

        scanner.close();
    }
}
