package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int COUNT_OF_ROUNDS = 3;

    public static void startGame(String[][] gameData, String gameDescription) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        System.out.println(gameDescription);

        for (int i = 0; i < COUNT_OF_ROUNDS; i++) {
            System.out.println("Question: " + gameData[i][0]);
            System.out.print("Your answer: ");
            String userAnswer = scanner.next();

            if (!userAnswer.equals(gameData[i][1])) {
                System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'. Let's try again, %s!%n",
                        userAnswer, gameData[i][1], userName);
                return;
            }
        }
        System.out.println("Congratulations, " + userName + "!");
    }
}
