package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Games {
    public static void startEvenGame(Scanner scanner) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.nextLine(); // scanner.next() изменено на nextLine()
        System.out.println("Hello, " + userName + "!");
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        Random random = new Random();
        int correctAnswersCount = 0;

        while (correctAnswersCount < 3) {
            int randomNumber = random.nextInt(100);
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
                correctAnswersCount = 0;
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
                default -> 0;
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
    public static void progression(Scanner scanner) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        System.out.println("What number is missing in the progression?");

        Random random = new Random();
        int correctAnswersCount = 0;

        while (correctAnswersCount < 3) {
            int start = random.nextInt(50);
            int step = random.nextInt(10) + 1;
            int missIndex = random.nextInt(10);
            int[] progression = new int[10];

            for (int i = 0; i < 10; i++) {
                progression[i] = start + i * step;
            }

            for (int i = 0; i < 10; i++) {
                System.out.print(i == missIndex ? ".. " : progression[i] + " ");
            }
            System.out.println();

            System.out.print("Your answer: ");
            String userAnswer = scanner.next();

            String correctAnswer = String.valueOf(start + missIndex * step);

            if (userAnswer.equals(correctAnswer)) {
                System.out.println("Correct!");
                correctAnswersCount++;
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '"
                        + correctAnswer + "'.");
                System.out.println("Let's try again, " + userName + "!");
                correctAnswersCount = 0;
            }
        }
        System.out.println("Congratulations, " + userName + "!");
    }

    public static void prime(Scanner scanner) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        Random random = new Random();
        int correctAnswersCount = 0;

        while (correctAnswersCount < 3) {
            int randomNumber1 = random.nextInt(100);
            System.out.println("Question: " + randomNumber1);
            System.out.print("Your answer: ");
            String userAnswer = scanner.next();

            int d = 2;
            while (randomNumber1 % d != 0 && d != randomNumber1) {
                d++;
            }
            String correctAnswer = (d == randomNumber1) ? "yes" : "no";

            if (userAnswer.equals(correctAnswer)) {
                System.out.println("Correct!");
                correctAnswersCount++;
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '"
                        + correctAnswer + "'.");
                System.out.println("Let's try again, " + userName + "!");
                correctAnswersCount = 0;
            }
        }
        System.out.println("Congratulations, " + userName + "!");
    }
}
