package hexlet.code.games;

import java.util.Scanner;

import hexlet.code.Engine;
import hexlet.code.utils.RandomNumberGenerator;

public class Progression {
    public static void run(int iterations, String userName, Scanner scanner) {
        System.out.println("What number is missing in the progression?");

        final int begin = 1;
        final int end = 10;
        String[] questions = new String[iterations];
        String[] correctAnswers = new String[iterations];
        for (int i = 0; i < iterations; i++) {
            String[] sequence = generateSequence();

            int unknownTermIndex = RandomNumberGenerator.generateBetween(begin, end);
            correctAnswers[i] = sequence[unknownTermIndex];

            sequence[unknownTermIndex] = "..";
            questions[i] = String.join(" ", sequence);
        }

        Engine.runGame(questions, correctAnswers, userName, scanner);
    }

    private static String[] generateSequence() {
        final int begin = 1;
        final int end = 10;
        final int sequenceLength = 10;
        int initialTerm = RandomNumberGenerator.generateBetween(begin, end);
        int commonDiff = RandomNumberGenerator.generateBetween(begin, end);

        String[] sequence = new String[sequenceLength];
        for (int i = 0; i < sequenceLength; i++) {
            int term = calculateSequenceTerm(initialTerm, commonDiff, i);
            sequence[i] = String.valueOf(term);
        }

        return sequence;
    }

    private static int calculateSequenceTerm(int initialTerm, int commonDiff, int n) {
        return initialTerm + (n - 1) * commonDiff;
    }
}
