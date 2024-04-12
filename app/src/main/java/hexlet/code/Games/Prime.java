package hexlet.code.Games;

import hexlet.code.Engine;
import java.util.Random;
public class Prime {

    private static final int NUM_ITERATIONS = 3;
    private static final int RANDOM_UPPER_BOUND = 100;

    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(RANDOM_UPPER_BOUND) + 1;
    }

    public static boolean isPrime(int num) {
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
        String[][] gameData = new String[NUM_ITERATIONS][2];
        for (int i = 0; i < NUM_ITERATIONS; i++) {
            int randomNumber = generateRandomNumber();
            gameData[i][0] = String.valueOf(randomNumber);
            gameData[i][1] = isPrime(randomNumber) ? "yes" : "no";
        }
        return gameData;
    }

    public static void startGame() {
        String[][] gameData = generateGameData();
        String gameDescription = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        Engine.startGame(gameData, gameDescription);
    }
}
