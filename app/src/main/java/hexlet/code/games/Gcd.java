package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Gcd {

    public static int findGreatestCommonDivisor(int num1, int num2) {
        while (num2 != 0) {

            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }

    public static String[][] generateGameData() {
        String[][] data = new String[Engine.COUNT_OF_ROUNDS][2];

        for (int i = 0; i < Engine.COUNT_OF_ROUNDS; i++) {
            int randomNumber1 = Utils.generateNumber(0, Engine.COUNT_OF_ROUNDS);
            int randomNumber2 = Utils.generateNumber(0, Engine.COUNT_OF_ROUNDS);
            data[i][0] = randomNumber1 + " " + randomNumber2;
            data[i][1] = String.valueOf(findGreatestCommonDivisor(randomNumber1, randomNumber2));
        }
        return data;
    }

    public static void startGame() {
        String[][] gameData = generateGameData();
        String gameDescription = "Find the greatest common divisor of given numbers.";
        Engine.startGame(gameData, gameDescription);
    }
}
