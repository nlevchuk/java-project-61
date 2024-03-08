package hexlet.code.games;

import java.util.Scanner;
import java.util.StringJoiner;

import hexlet.code.Engine;
import hexlet.code.utils.RandomNumberGenerator;

public class Progression {
    public static void run(int iterations, String userName, Scanner scanner) {
        System.out.println("What number is missing in the progression?");

        final int begin = 1;
        final int end = 10;
        final int sequenceLength = 10;
        String[] questions = new String[iterations];
        String[] correctAnswers = new String[iterations];
        for (int i = 0; i < iterations; i++) {
            int initialTerm = RandomNumberGenerator.generateBetween(begin, end);
            int commonDiff = RandomNumberGenerator.generateBetween(begin, end);
            int unknownTermIndex = RandomNumberGenerator.generateBetween(begin, end);

            StringJoiner sequenceBuilder = new StringJoiner(" ");
            for (int n = 1; n <= sequenceLength; n++) {
                int term = calculateSequenceTerm(initialTerm, commonDiff, n);
                if (n == unknownTermIndex) {
                    sequenceBuilder.add("..");
                    correctAnswers[i] = String.valueOf(term);
                } else {
                    sequenceBuilder.add(String.valueOf(term));
                }
            }

            questions[i] = sequenceBuilder.toString();
        }

        Engine.runGame(questions, correctAnswers, userName, scanner);
    }

    private static int calculateSequenceTerm(int initialTerm, int commonDiff, int n) {
        return initialTerm + (n - 1) * commonDiff;
    }
}
