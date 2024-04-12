package Games;

import hexlet.code.Engine;
import java.util.Random;
import java.util.Scanner;

class Even {
    private static final int NUM_ITERATIONS = 3;
    private static final int RANDOM_UPPER_BOUND = 100;

    // Метод, возвращающий случайное число
    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(RANDOM_UPPER_BOUND);
    }

    // Метод, передающий сгенерированные данные и описание игры в движок
    public static void startGame(Scanner scanner) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        int correctAnswersCount = 0;

        while (correctAnswersCount < NUM_ITERATIONS) {
            int randomNumber = generateRandomNumber();
            System.out.println("Question: " + randomNumber);
            System.out.print("Your answer: ");
            String userAnswer = scanner.next();

            String correctAnswer = (randomNumber % 2 == 0) ? "yes" : "no";

            if (!userAnswer.equalsIgnoreCase(correctAnswer)) {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '"
                        + correctAnswer + "'.");
                System.out.println("Let's try again, " + userName + "!");
                return; // Завершаем метод при неверном ответе
            }

            System.out.println("Correct!");
            correctAnswersCount++;
        }

        System.out.println("Congratulations, " + userName + "!");
    }
}