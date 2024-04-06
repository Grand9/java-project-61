package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class EvenGame {
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


public class CalculatorGame {

    private static final int NUM_ITERATIONS = 3;
    private static final int RANDOM_UPPER_BOUND = 100;
    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(RANDOM_UPPER_BOUND);
    }

    public static int correctResult(int num1, int num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
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
            int signIndex = random.nextInt(3); // 3 - количество знаков: +, -, *
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

            int correctAnswer = correctResult(randomNumber1,randomNumber2, sign);


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

public class GcdGame {

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
    public static void gcd(Scanner scanner) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        System.out.println("Find the greatest common divisor of given numbers.");

        Random random = new Random();
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

            correctAnswer = correctResult(randomNumber1,randomNumber2);

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

class ProgressionGame {

    private static final int NUM_ITERATIONS = 3;
    private static final int RANDOM_UPPER_BOUND = 100;
    private static final int RANDOM_STEP_RANGE = 10;

    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(RANDOM_UPPER_BOUND) + 1;
    }
    public static int generateRandomStepRange() {
        Random random = new Random();
        return random.nextInt(RANDOM_STEP_RANGE) + 1;
    }

    public static int correctResult(int startNum,int missIndex,int step) {
        return startNum + missIndex * step;
    }
    public static void progression(Scanner scanner) {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        System.out.println("What number is missing in the progression?");

        Random random = new Random();
        int correctAnswersCount = 0;

        while (correctAnswersCount < NUM_ITERATIONS) {
            int start = generateRandomNumber();
            int step = random.nextInt(RANDOM_STEP_RANGE) + 1;
            int missIndex = generateRandomStepRange();
            int[] progression = new int RANDOM_STEP_RANGE;

            StringBuilder question = new StringBuilder();
            for (int i = 0; i < RANDOM_STEP_RANGE(); i++) {
                progression[i] = start + i * step;
                question.append(i == missIndex ? ".. " : progression[i] + " ");
            }

            System.out.println("Question: " + question);
            System.out.print("Your answer: ");

            // Проверяем, что введено целое число
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer answer.");
                scanner.next(); // Чистка неверного ввода
                continue; // Пропускаем итерацию цикла и продолжаем игру
            }

            int userAnswer = scanner.nextInt();

            int correctAnswer = correctResult(start, missIndex, step);

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
class PrimeGame {
    public static void prime(Scanner scanner) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        Random random = new Random();
        int correctAnswersCount = 0;

        while (correctAnswersCount < NUM_ITERATIONS) {
            int randomNumber1 = random.nextInt(RANDOM_UPPER_BOUND);
            System.out.println("Question: " + randomNumber1);
            System.out.print("Your answer: ");
            String userAnswer = scanner.next();

            // Проверка корректности ввода пользователя
            if (!userAnswer.equals("yes") && !userAnswer.equals("no")) {
                System.out.println("Invalid input. Please answer 'yes' or 'no'.");
                continue; // Пропускаем итерацию цикла и продолжаем игру
            }

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
                return; // Прерываем игру при неверном ответе
            }
        }
        System.out.println("Congratulations, " + userName + "!");
    }
}

