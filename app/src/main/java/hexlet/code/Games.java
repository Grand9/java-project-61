package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Games {
    public static void startEvenGame(Scanner scanner) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        Random random = new Random();
        int correctAnswersCount = 0;

        while (correctAnswersCount < 3) {
            int randomNumber = random.nextInt(1000);
            System.out.println("Question: " + randomNumber);
            System.out.print("Your answer: ");
            String userAnswer = scanner.next();

            String correctAnswer = (randomNumber % 2 == 0) ? "yes" : "no";

            if (userAnswer.equalsIgnoreCase(correctAnswer)) {
                System.out.println("Correct!");
                correctAnswersCount++;
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '"
                        + correctAnswer + "'.");
                System.out.println("Let's try again, " + userName + "!");
                correctAnswersCount = 0; // Сброс счетчика правильных ответов
            }
        }

        System.out.println("Congratulations, " + userName + "!");
    }

    public static void calculator(Scanner scanner) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        System.out.println("What is the result of the expression?");

        Random random = new Random();
        int correctAnswersCount = 0;

        while (correctAnswersCount < 3) {
            int randomNumber1 = random.nextInt(100);
            int randomNumber2 = random.nextInt(50);
            int signIndex = random.nextInt(3);
            char[] signs = {'+', '-', '*'};
            char sign = signs[signIndex];

            System.out.println("Question: " + randomNumber1 + " " + sign + " " + randomNumber2);
            System.out.print("Your answer: ");
            int userAnswer;
            if (scanner.hasNextInt()) {
                userAnswer = scanner.nextInt();
            } else {
                System.out.println("Invalid input. Please enter a numeric answer.");
                scanner.next(); // Чистка неверного ввода
                continue; // Пропускаем итерацию цикла и продолжаем игру
            }

            int correctAnswer = switch (sign) {
                case '+' -> randomNumber1 + randomNumber2;
                case '-' -> randomNumber1 - randomNumber2;
                case '*' -> randomNumber1 * randomNumber2;
                default -> 0; // Default value
            };

            if (userAnswer == correctAnswer) {
                System.out.println("Correct!");
                correctAnswersCount++;
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '"
                        + correctAnswer + "'.");
                System.out.println("Let's try again, " + userName + "!");
                correctAnswersCount = 0; // Сброс счетчика правильных ответов
            }
        }

        System.out.println("Congratulations, " + userName + "!");
    }
    public static void gcd(Scanner scanner) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        System.out.println("Find the greatest common divisor of given numbers.");

        Random random = new Random();
        int correctAnswersCount = 0;

        while (correctAnswersCount < 3) {
            int randomNumber1 = random.nextInt(50);
            int randomNumber2 = random.nextInt(50);
            System.out.println("Question: " + randomNumber1 + " " + randomNumber2);
            System.out.print("Your answer: ");
            String userAnswer = scanner.next();

            int correctAnswer;
            // Находим наибольший общий делитель
            while (randomNumber2 != 0) {
                int temp = randomNumber2;
                randomNumber2 = randomNumber1 % randomNumber2;
                randomNumber1 = temp;
            }
            correctAnswer = randomNumber1;

            if (userAnswer.equals(String.valueOf(correctAnswer))) {
                System.out.println("Correct!");
                correctAnswersCount++;
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '"
                        + correctAnswer + "'.");
                System.out.println("Let's try again, " + userName + "!");
                correctAnswersCount = 0; // Сброс счетчика правильных ответов
            }
        }

        System.out.println("Congratulations, " + userName + "!");
    }
}
