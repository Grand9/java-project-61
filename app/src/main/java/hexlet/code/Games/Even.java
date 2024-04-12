package hexlet.code.Games;

import hexlet.code.Engine;
import java.util.Random;

public class Even {

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
            int randomNumber = generateRandomNumber();
            data[i][0] = String.valueOf(randomNumber);
            data[i][1] = (randomNumber % 2 == 0) ? "yes" : "no";
        }
        return data;
    }

    public static void startGame() {
        String[][] gameData = generateGameData();
        String gameDescription = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        Engine.startGame(gameData, gameDescription);
    }
}
