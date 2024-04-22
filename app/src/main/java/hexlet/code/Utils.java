package hexlet.code;

public class Utils {
    public static final int RANDOM_UPPER_BOUND = 100;

    public static int generateNumber(int lowBoundOfInterval, int upperBoundOfInterval) {
        return (int) Math.floor(Math.random() * (upperBoundOfInterval - lowBoundOfInterval + 1)) + lowBoundOfInterval;
    }
}
