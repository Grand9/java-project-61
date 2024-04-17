package hexlet.code.Games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Progression {

    private static final int PROGRESSION_LENGTH = 10;  // Set length of the arithmetic progression

    public static String[][] generateGameData() {
        String[][] gameData = new String[Engine.COUNT_OF_ROUNDS][2];

        for (int i = 0; i < Engine.COUNT_OF_ROUNDS; i++) {
            int start = Utils.generateNumber(0, 100);
            int step = Utils.generateNumber(1, 10);  // Ensuring step is at least 1 to avoid a static progression
            int missIndex = Utils.generateNumber(0, PROGRESSION_LENGTH - 1);
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
