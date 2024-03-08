package hexlet.code.games;

import java.util.Scanner;

import hexlet.code.Engine;
import hexlet.code.utils.RandomNumberGenerator;

public class Gcd {
    public static void run(int iterations, String userName, Scanner scanner) {
        System.out.println("Find the greatest common divisor of given numbers.");

        int begin = 1;
        int end = 100;
        String[] questions = new String[iterations];
        String[] correctAnswers = new String[iterations];
        for (int i = 0; i < iterations; i++) {
            int firstNumber = RandomNumberGenerator.generateBetween(begin, end);
            int secondNumber = RandomNumberGenerator.generateBetween(begin, end);

            questions[i] = firstNumber + " " + secondNumber;
            int correctAnswer = computeGcd(firstNumber, secondNumber);
            correctAnswers[i] = String.valueOf(correctAnswer);
        }

        Engine.runGame(questions, correctAnswers, userName, scanner);
    }

    private static int computeGcd(int firstNumber, int secondNumber) {
        int a = firstNumber;
        int b = secondNumber;

        while (!(a == 0 || b == 0)) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }

        return a == 0 ? b : a;
    }
}
