package Games;

import hexlet.code.Engine;
import java.util.Random;
import java.util.Scanner;

class Prime {

    private static final int NUM_ITERATIONS = 3;
    private static final int RANDOM_UPPER_BOUND = 100;

    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(RANDOM_UPPER_BOUND) + 1;
    }

    public static boolean isPrime(int num1) {
        if (num1 <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num1); i++) {
            if (num1 % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void startGame(Scanner scanner) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        int correctAnswersCount = 0;

        while (correctAnswersCount < NUM_ITERATIONS) {
            int randomNumber1 = generateRandomNumber();
            System.out.println("Question: " + randomNumber1);
            System.out.print("Your answer: ");
            String userAnswer = scanner.next();

            // Проверка корректности ввода пользователя
            if (!userAnswer.equals("yes") && !userAnswer.equals("no")) {
                System.out.println("Invalid input. Please answer 'yes' or 'no'.");
                continue; // Пропускаем итерацию цикла и продолжаем игру
            }

            boolean isPrime = isPrime(randomNumber1);
            String correctAnswer = isPrime ? "yes" : "no";

            if (userAnswer.equals(correctAnswer)) {
                System.out.println("Correct!");
                correctAnswersCount++;
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '"
                        + correctAnswer + "'.");
                System.out.println("Let's try again, " + userName + "!");
                return; // Прерываем игру при неверном ответе
            }
        }
        System.out.println("Congratulations, " + userName + "!");
    }
}