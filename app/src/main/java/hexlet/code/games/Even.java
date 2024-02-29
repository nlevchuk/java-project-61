package hexlet.code.games;

import java.util.Scanner;

public class Even {
    public static void run(String userName, Scanner scanner) {
        int iterations = 3;

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        for (int i = 0; i < iterations; i++) {
            int currentNumber = generateRandomNumber();

            System.out.println("Question: " + currentNumber);
            System.out.print("Your answer: ");
            String userAnswer = scanner.next();
            String correctAnswer = getCorrectAnswer(currentNumber);

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

    private static int generateRandomNumber() {
        int randomNumber = (int) (Math.random() * 100);
        return randomNumber;
    }

    private static String getCorrectAnswer(int number) {
        return isEvenNumber(number) ? "yes" : "no";
    }

    private static boolean isEvenNumber(int number) {
        return number % 2 == 0;
    }
}
