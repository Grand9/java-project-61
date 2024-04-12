package hexlet.code.Games;

import hexlet.code.Engine;
import java.util.Random;

public class Progression {

    private static final int NUM_ITERATIONS = 3;
    private static final int PROGRESSION_LENGTH = 10;  // Set length of the arithmetic progression
    private static final int MAX_START_VALUE = 100;
    private static final int MAX_STEP = 10;

    public static int generateRandomNumber(int upperBound) {
        Random random = new Random();
        return random.nextInt(upperBound) + 1;
    }

    public static String[][] generateGameData() {
        String[][] gameData = new String[NUM_ITERATIONS][2];
        Random random = new Random();

        for (int i = 0; i < NUM_ITERATIONS; i++) {
            int start = generateRandomNumber(MAX_START_VALUE);
            int step = generateRandomNumber(MAX_STEP);
            int missIndex = random.nextInt(PROGRESSION_LENGTH);
            int[] progression = new int[PROGRESSION_LENGTH];
            StringBuilder question = new StringBuilder();

            for (int j = 0; j < PROGRESSION_LENGTH; j++) {
                progression[j] = start + j * step;
                if (j == missIndex) {
                    question.append(".. ");
                } else {
                    question.append(progression[j]).append(" ");
                }
            }

            gameData[i][0] = question.toString().trim();
            gameData[i][1] = String.valueOf(progression[missIndex]);
        }

        return gameData;
    }

    public static void startGame() {
        String[][] gameData = generateGameData();
        String gameDescription = "What number is missing in the progression?";
        Engine.startGame(gameData, gameDescription);
    }
}
