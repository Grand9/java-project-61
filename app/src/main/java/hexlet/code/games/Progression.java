package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Progression {

    private static final int PROGRESSION_LENGTH = 10;
    private static final String GAME_DESCRIPTION = "What number is missing in the progression?";
    public static String[][] generateGameData() {
        String[][] gameData = new String[Engine.COUNT_OF_ROUNDS][2];

        for (int i = 0; i < Engine.COUNT_OF_ROUNDS; i++) {
            int start = Utils.generateNumber(0, Utils.RANDOM_UPPER_BOUND);
            int step = Utils.generateNumber(1, PROGRESSION_LENGTH);
            int missIndex = Utils.generateNumber(0, PROGRESSION_LENGTH - 1);

            String[] progression = generateArithmeticProgression(start, step);
            progression[missIndex] = "..";

            String question = String.join(" ", progression);
            String answer = String.valueOf(start + step * missIndex);

            gameData[i][0] = question;
            gameData[i][1] = answer;
        }

        return gameData;
    }

    public static void startGame() {
        String[][] gameData = generateGameData();
        Engine.startGame(gameData, GAME_DESCRIPTION);
    }

    private static String[] generateArithmeticProgression(int first, int step) {
        String[] progression = new String[Progression.PROGRESSION_LENGTH];
        for (int i = 0; i < Progression.PROGRESSION_LENGTH; i++) {
            progression[i] = String.valueOf(first + i * step);
        }
        return progression;
    }

}
