package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Progression {

    private static final int PROGRESSION_LENGTH = 10;

    public static String[][] generateGameData() {
        String[][] gameData = new String[Engine.COUNT_OF_ROUNDS][2];

        for (int i = 0; i < Engine.COUNT_OF_ROUNDS; i++) {
            int start = Utils.generateNumber(0, Utils.RANDOM_UPPER_BOUND);
            int step = Utils.generateNumber(1, PROGRESSION_LENGTH);
            int[] progression = Utils.generateArithmeticProgression(start, step, PROGRESSION_LENGTH);
            int missIndex = Utils.generateNumber(0, PROGRESSION_LENGTH - 1);

            String question = Utils.formatProgressionQuestion(progression, missIndex);

            gameData[i][0] = question;
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
