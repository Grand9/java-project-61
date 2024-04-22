package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {


    public static String[][] generateGameData() {
        String[][] data = new String[Engine.COUNT_OF_ROUNDS][2];

        for (int i = 0; i < Engine.COUNT_OF_ROUNDS; i++) {
            int randomNumber = Utils.generateNumber(0, Utils.RANDOM_UPPER_BOUND);
            data[i][0] = String.valueOf(randomNumber);
            data[i][1] = isEven(randomNumber) ? "yes" : "no";
        }
        return data;
    }

    public static void startGame() {
        String[][] gameData = generateGameData();
        String gameDescription = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        Engine.startGame(gameData, gameDescription);
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
