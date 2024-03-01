package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static void runGame(Game game, String userName, Scanner scanner) {
        final int iterations = 3;

        System.out.println(game.getRule());

        for (int i = 0; i < iterations; i++) {
            String question = game.getQuestion();

            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String userAnswer = scanner.next();
            String correctAnswer = game.getCorrectAnswer(question);

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
