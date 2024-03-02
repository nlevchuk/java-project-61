package hexlet.code.games;

import hexlet.code.Game;
import hexlet.code.utils.RandomNumberGenerator;

public class Gcd implements Game {
    public String getRule() {
        return "Find the greatest common divisor of given numbers.";
    }

    public String getQuestion() {
        int firstNumber = RandomNumberGenerator.generate(100);
        int secondNumber = RandomNumberGenerator.generate(100);

        return firstNumber + " " + secondNumber;
    }

    public String getCorrectAnswer(String question) {
        String[] parts = question.split(" ");
        int firstNumber = Integer.valueOf(parts[0]);
        int secondNumber = Integer.valueOf(parts[1]);

        return computeGcd(firstNumber, secondNumber);
    }

    private String computeGcd(int firstNumber, int secondNumber) {
        int a = firstNumber;
        int b = secondNumber;
        while (!(a == 0 || b == 0)) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }

        int gcd = a == 0 ? b : a;
        return String.valueOf(gcd);
    }
}
