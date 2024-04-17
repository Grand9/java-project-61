package hexlet.code.Games;

import hexlet.code.Engine;
import java.util.Random;
import hexlet.code.Utils;

public class Even {

    private static final int RANDOM_UPPER_BOUND = 100;



    public static String[][] generateGameData() {
        String[][] data = new String[Engine.COUNT_OF_ROUNDS][2];
        Random random = new Random();

        for (int i = 0; i < Engine.COUNT_OF_ROUNDS; i++) {
            int randomNumber = Utils.generateNumber(0, 100);
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
