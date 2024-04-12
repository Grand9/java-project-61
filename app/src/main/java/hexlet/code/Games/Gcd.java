package hexlet.code.Games;

import hexlet.code.Engine;

import java.util.Random;

public class Gcd {

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

    public static String[][] generateGameData() {
        String[][] data = new String[NUM_ITERATIONS][2];

        for (int i = 0; i < NUM_ITERATIONS; i++) {
            int randomNumber1 = generateRandomNumber();
            int randomNumber2 = generateRandomNumber();
            data[i][0] = randomNumber1 + " " + randomNumber2;
            data[i][1] = String.valueOf(correctResult(randomNumber1, randomNumber2));
        }
        return data;
    }

    public static void startGame() {
        String[][] gameData = generateGameData();
        String gameDescription = "Find the greatest common divisor of given numbers.";
        Engine.startGame(gameData, gameDescription);
    }
}
