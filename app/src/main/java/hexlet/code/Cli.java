package hexlet.code;

import java.util.Scanner;

class Cli {
    public static void greetings(Scanner scanner) {
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
    }
}
