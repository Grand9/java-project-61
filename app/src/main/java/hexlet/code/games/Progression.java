package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.Arrays;

public class Progression {

    private static final int PROGRESSION_LENGTH = 10;

    public static String[][] generateGameData() {
        String[][] gameData = new String[Engine.COUNT_OF_ROUNDS][2];

        for (int i = 0; i < Engine.COUNT_OF_ROUNDS; i++) {
            int start = Utils.generateNumber(0, Utils.RANDOM_UPPER_BOUND);
            int step = Utils.generateNumber(1, PROGRESSION_LENGTH);
            int[] progression = generateArithmeticProgression(start, step);
            int missIndex = Utils.generateNumber(0, PROGRESSION_LENGTH - 1);

            progression[missIndex] = -1;
            String question = formatProgressionQuestion(progression, missIndex);

            gameData[i][0] = question;
            gameData[i][1] = String.valueOf(start + step * missIndex);
        }

        return gameData;
    }

    public static void startGame() {
        String[][] gameData = generateGameData();
        String gameDescription = "What number is missing in the progression?";
        Engine.startGame(gameData, gameDescription);
    }

    private static int[] generateArithmeticProgression(int first, int step) {
        int[] progression = new int[Progression.PROGRESSION_LENGTH];
        for (int i = 0; i < Progression.PROGRESSION_LENGTH; i++) {
            progression[i] = first + i * step;
        }
        return progression;
    }

    private static String formatProgressionQuestion(int[] progression, int missIndex) {
        progression[missIndex] = 0;
        return String.join(" ",
                Arrays.stream(progression)
                        .mapToObj(num -> num == 0 ? ".." : String.valueOf(num))
                        .toArray(String[]::new));
    }
}
