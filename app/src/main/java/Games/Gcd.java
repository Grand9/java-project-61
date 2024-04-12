package Games;

import hexlet.code.Engine;
import java.util.Random;
import java.util.Scanner;

class Gcd{

    private static final int NUM_ITERATIONS = 3;
    private static final int RANDOM_UPPER_BOUND = 100;
    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(RANDOM_UPPER_BOUND) + 1;
    }

    public static int correctResult(int num1, int num2) {
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }
    public static void startGame(Scanner scanner) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        System.out.println("Find the greatest common divisor of given numbers.");

        int correctAnswersCount = 0;

        while (correctAnswersCount < NUM_ITERATIONS) {
            int randomNumber1 = generateRandomNumber();
            int randomNumber2 = generateRandomNumber();
            System.out.println("Question: " + randomNumber1 + " " + randomNumber2);
            System.out.print("Your answer: ");

            // Проверяем, что введено целое число
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer answer.");
                scanner.next(); // Чистка неверного ввода
                continue; // Пропускаем итерацию цикла и продолжаем игру
            }

            int userAnswer = scanner.nextInt();

            int correctAnswer;
            // Находим наибольший общий делитель

            correctAnswer = correctResult(randomNumber1, randomNumber2);

            if (userAnswer == correctAnswer) {
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