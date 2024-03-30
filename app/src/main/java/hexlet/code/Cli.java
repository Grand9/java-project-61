package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void welcomeUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("May I have your name? ");
        String userName = scanner.nextLine();
        System.out.println("Hello, " + userName + "!");
        scanner.close();
    }
}
