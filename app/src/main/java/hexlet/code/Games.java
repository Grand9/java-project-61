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
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
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
            int randomNumber2 = random.nextInt(100);
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
                scanner.next(); // Clear the invalid input
                continue; // Пропускаем итерацию цикла и продолжаем игру
            }

            int correctAnswer;
            switch (sign) {
                case '+':
                    correctAnswer = randomNumber1 + randomNumber2;
                    break;
                case '-':
                    correctAnswer = randomNumber1 - randomNumber2;
                    break;
                case '*':
                    correctAnswer = randomNumber1 * randomNumber2;
                    break;
                default:
                    correctAnswer = 0; // Default value
                    break;
            }

            if (userAnswer == correctAnswer) {
                System.out.println("Correct!");
                correctAnswersCount++;
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
                System.out.println("Let's try again, " + userName + "!");
                correctAnswersCount = 0; // Сброс счетчика правильных ответов
            }
        }

        System.out.println("Congratulations, " + userName + "!");
    }
}
