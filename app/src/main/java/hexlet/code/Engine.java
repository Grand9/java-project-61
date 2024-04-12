package hexlet.code;

import java.util.Scanner;
public class Engine {
    public static final int CORRECT_ANSWER_COUNT = 3;
    public static void communicateGamer(String[][] answersAndQuestions, String gameQuestion, String gamerName) {
        Scanner answerReceiver = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = answerReceiver.next();
        System.out.println("Hello, " + userName + "!");
        System.out.println(gameQuestion);

        for (int i = 0; i < CORRECT_ANSWER_COUNT; i++) {
            String question = answersAndQuestions[i][0];
            String correctAnswer = answersAndQuestions[i][1];

            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String gamerAnswer = answerReceiver.next();

            if (gamerAnswer.equals(correctAnswer)) {
                System.out.println("Correct!");
            } else {
                System.out.printf("'" + userAnswer + "' is wrong answer ;(. Correct answer was '",
                        gamerAnswer, correctAnswer, gamerName);
                return;
            }
        }
        System.out.println("Congratulations, " + gamerName + "!");
    }
}