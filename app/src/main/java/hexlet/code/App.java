package hexlet.code;

import Games.Calculator;

import java.util.Scanner;

public class App {
    private static final int GREET_GAME = 1;
    private static final int EVEN_GAME = 2;
    private static final int CALC_GAME = 3;
    private static final int GCD_GAME = 4;
    private static final int PROGRESSION_GAME = 5;
    private static final int PRIME_GAME = 6;
    private static final int EXIT_GAME = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        System.out.println(GREET_GAME + " - Greet");
        System.out.println(EVEN_GAME + " - Even");
        System.out.println(CALC_GAME + " - Calc");
        System.out.println(GCD_GAME + " - GCD");
        System.out.println(PROGRESSION_GAME + " - Progression");
        System.out.println(PRIME_GAME + " - Prime");
        System.out.println(EXIT_GAME + " - Exit");
        System.out.print("Your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case GREET_GAME:
                Cli.greetings();
                break;
            case EXIT_GAME:
                System.out.println("Goodbye!");
                break;
            case EVEN_GAME:
                EvenGame.startGame(scanner);
                break;
            case CALC_GAME:
                Calculator.startGame(scanner);
                break;
            case GCD_GAME:
                GcdGame.startGame(scanner);
                break;
            case PROGRESSION_GAME:
                ProgressionGame.startGame(scanner);
                break;
            case PRIME_GAME:
                PrimeGame.startGame(scanner);
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid game number.");
                break;
        }

        scanner.close();
    }
}
