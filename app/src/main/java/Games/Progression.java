package Games;

import hexlet.code.Engine;
import java.util.Random;
import java.util.Scanner;

class Progression {

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

    public static int correctResult(int startNum, int missIndex, int step) {
        return startNum + missIndex * step;
    }
    public static void startGame(Scanner scanner) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        System.out.println("What number is missing in the progression?");

        Random random = new Random();
        int correctAnswersCount = 0;
        int missIndex = generateRandomStepRange();

        while (correctAnswersCount < NUM_ITERATIONS) {
            int start = generateRandomNumber();
            int step = random.nextInt(RANDOM_STEP_RANGE) + 1;
            int[] progression = new int[RANDOM_STEP_RANGE];


            StringBuilder question = new StringBuilder();
            for (int i = 0; i < RANDOM_STEP_RANGE; i++) {
                if (i == missIndex) {
                    question.append(".. ");
                } else {
                    progression[i] = start + i * step;
                    question.append(progression[i]).append(" ");
                }
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
