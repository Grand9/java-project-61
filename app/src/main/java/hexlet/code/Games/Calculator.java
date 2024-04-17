package hexlet.code.Games;

import hexlet.code.Engine;
import java.util.Random;
import hexlet.code.Utils;

public class Calculator {

    public static String[][] generateGameData() {
        String[][] data = new String[Engine.COUNT_OF_ROUNDS][2];
        Random random = new Random();

        for (int i = 0; i < Engine.COUNT_OF_ROUNDS; i++) {
            int num1 = Utils.generateNumber(0, Utils.RANDOM_UPPER_BOUND);
            int num2 = Utils.generateNumber(0, Utils.RANDOM_UPPER_BOUND);
            char[] signs = {'+', '-', '*'};
            char sign = signs[random.nextInt(signs.length)];
            int correctAnswer = calculate(num1, num2, sign);
            data[i][0] = num1 + " " + sign + " " + num2;
            data[i][1] = String.valueOf(correctAnswer);
        }
        return data;
    }

    public static int calculate(int num1, int num2, char operator) {
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
