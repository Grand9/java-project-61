package hexlet.code;

import java.util.Scanner;
import java.util.Random;

public class Cli {

    public static void welcomeUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.nextLine();
        System.out.println("Hello, " + userName + "!");
        scanner.close();
    }

    public static void startEvenGame(Scanner scanner) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        Random random = new Random();
        int correctAnswersCount = 0;

        while (correctAnswersCount < 3) {
            int randomNumber = random.nextInt(100); // Генерируем случайное число от 0 до 99
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
                correctAnswersCount = 0; // Сбрасываем счётчик правильных ответов
            }
        }

        System.out.println("Congratulations, " + userName + "!");
    }
}
