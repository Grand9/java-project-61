package hexlet.code;

public class Utils {
    public static final int RANDOM_UPPER_BOUND = 100;

    public static int generateNumber(int lowBoundOfInterval, int upperBoundOfInterval) {
        return (int) Math.floor(Math.random() * (upperBoundOfInterval - lowBoundOfInterval + 1)) + lowBoundOfInterval;
    }

    public static int[] generateArithmeticProgression(int first, int step, int length) {
        int[] progression = new int[length];
        for (int i = 0; i < length; i++) {
            progression[i] = first + i * step;
        }
        return progression;
    }

    public static String formatProgressionQuestion(int[] progression, int missIndex) {
        StringBuilder question = new StringBuilder();
        for (int i = 0; i < progression.length; i++) {
            if (i == missIndex) {
                question.append(".. ");
            } else {
                question.append(progression[i]).append(" ");
            }
        }
        return question.toString().trim();
    }
}
