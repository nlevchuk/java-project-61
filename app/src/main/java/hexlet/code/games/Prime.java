package hexlet.code.games;

import java.util.Scanner;

import hexlet.code.Engine;
import hexlet.code.utils.RandomNumberGenerator;

public class Prime {
    public static void run(int iterations, String userName, Scanner scanner) {
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        int begin = 2;
        int end = 100;
        String[] questions = new String[iterations];
        String[] correctAnswers = new String[iterations];
        for (int i = 0; i < iterations; i++) {
            int number = RandomNumberGenerator.generateBetween(begin, end);
            questions[i] = String.valueOf(number);
            correctAnswers[i] = isPrimeNumber(number) ? "yes" : "no";
        }

        Engine.runGame(questions, correctAnswers, userName, scanner);
    }

    // Use the Trial Division algorithm
    private static boolean isPrimeNumber(int number)  {
        int firstFactor = 2;
        int lastFactor = ((int) Math.sqrt(number)) + 1;

        for (int i = firstFactor; i <= lastFactor; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
