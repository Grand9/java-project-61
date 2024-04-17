package hexlet.code;

public class Utils {
    public static int generateNumber(int lowBoundOfInterval, int upperBoundOfInterval) {
        return (int) Math.floor(Math.random() * (upperBoundOfInterval - lowBoundOfInterval + 1)) + lowBoundOfInterval;
    }
}
