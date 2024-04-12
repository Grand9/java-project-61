package hexlet.code.Games;

import hexlet.code.Engine;
import java.util.Random;

public class Calculator {

    private static final int NUM_ITERATIONS = 3;
    private static final int RANDOM_UPPER_BOUND = 100;

    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(RANDOM_UPPER_BOUND);
    }

    public static String[][] generateGameData() {
        String[][] data = new String[NUM_ITERATIONS][2];
        Random random = new Random();

        for (int i = 0; i < NUM_ITERATIONS; i++) {
            int num1 = generateRandomNumber();
            int num2 = generateRandomNumber();
            char[] signs = {'+', '-', '*'};
            char sign = signs[random.nextInt(signs.length)];
            int correctAnswer = correctResult(num1, num2, sign);
            data[i][0] = num1 + " " + sign + " " + num2;
            data[i][1] = String.valueOf(correctAnswer);
        }
        return data;
    }

    public static int correctResult(int num1, int num2, char operator) {
        return switch (operator) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            default -> throw new IllegalArgumentException("Invalid operator: " + operator);
        };
    }

    public static void startGame() {
        String[][] gameData = generateGameData();
        String gameDescription = "What is the result of the expression?";
        Engine.startGame(gameData, gameDescription);
    }
}
