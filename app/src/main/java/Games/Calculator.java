package Games;

import hexlet.code.Engine;
import java.util.Random;
import java.util.Scanner;

class Calculator {

    private static final int NUM_ITERATIONS = 3;
    private static final int RANDOM_UPPER_BOUND = 100;
    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(RANDOM_UPPER_BOUND);
    }

    public static int correctResult(int num1, int num2, char operator) {
        return switch (operator) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            default -> throw new IllegalArgumentException("Invalid operator: " + operator);
        };
    }

    public static void startGame(Scanner scanner) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        System.out.println("What is the result of the expression?");

        Random random = new Random();
        int correctAnswersCount = 0;

        while (correctAnswersCount < NUM_ITERATIONS) {
            int randomNumber1 = generateRandomNumber();
            int randomNumber2 = generateRandomNumber();
            int signIndex = random.nextInt(NUM_ITERATIONS); // 3 - количество знаков: +, -, *
            char[] signs = {'+', '-', '*'};
            char sign = signs[signIndex];

            System.out.println("Question: " + randomNumber1 + " " + sign + " " + randomNumber2);
            System.out.print("Your answer: ");

            // Проверяем, что введено целое число
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a numeric answer.");
                scanner.next(); // Чистка неверного ввода
                continue; // Пропускаем итерацию цикла и продолжаем игру
            }

            int userAnswer = scanner.nextInt();

            int correctAnswer = correctResult(randomNumber1, randomNumber2, sign);


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
