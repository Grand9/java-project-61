package hexlet.code.Games;

import hexlet.code.Engine;
import hexlet.code.Utils;


public class Prime {

    public static boolean checkIfPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static String[][] generateGameData() {
        String[][] gameData = new String[Engine.COUNT_OF_ROUNDS][2];
        for (int i = 0; i < Engine.COUNT_OF_ROUNDS; i++) {
            int randomNumber = Utils.generateNumber(0, 100);
            gameData[i][0] = String.valueOf(randomNumber);
            gameData[i][1] = checkIfPrime(randomNumber) ? "yes" : "no";
        }
        return gameData;
    }

    public static void startGame() {
        String[][] gameData = generateGameData();
        String gameDescription = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        Engine.startGame(gameData, gameDescription);
    }
}
