package hexlet.code.games;

import hexlet.code.Game;
import hexlet.code.utils.RandomNumberGenerator;

public class Prime implements Game {
    public int getNumber() {
        return 6;
    }

    public String getName() {
        return "Prime";
    }

    public String getRule() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    public String getQuestion() {
        // From 2 to 101
        int number = RandomNumberGenerator.generate(100) + 1;

        return String.valueOf(number);
    }

    public String getCorrectAnswer(String question) {
        int number = Integer.valueOf(question);

        return isPrimeNumber(number) ? "yes" : "no";
    }

    // Use the Trial Division algorithm
    private boolean isPrimeNumber(int number)  {
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
