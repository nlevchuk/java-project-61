package hexlet.code.games;

import java.util.Scanner;

import hexlet.code.Engine;
import hexlet.code.utils.RandomNumberGenerator;

public class Even {
    public static void run(int iterations, String userName, Scanner scanner) {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        int begin = 1;
        int end = 100;
        String[] questions = new String[iterations];
        String[] correctAnswers = new String[iterations];
        for (int i = 0; i < iterations; i++) {
            int number = RandomNumberGenerator.generateBetween(begin, end);
            questions[i] = String.valueOf(number);
            correctAnswers[i] = isEvenNumber(number) ? "yes" : "no";
        }

        Engine.runGame(questions, correctAnswers, userName, scanner);
    }

    private static boolean isEvenNumber(int number) {
        return number % 2 == 0;
    }
}
