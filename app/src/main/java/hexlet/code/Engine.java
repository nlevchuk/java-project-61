package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static void runGame(String[] questions, String[] correctAnswers, String userName, Scanner scanner) {
        for (int i = 0; i < questions.length; i++) {
            String question = questions[i];
            String correctAnswer = correctAnswers[i];

            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String userAnswer = scanner.next();

            if (userAnswer.equals(correctAnswer)) {
                System.out.println("Correct!");
                continue;
            }

            System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
            System.out.println("Let's try again, " + userName + "!");
            return;
        }

        System.out.println("Congratulations, " + userName + "!");
    }
}
