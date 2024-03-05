package hexlet.code.games;

import hexlet.code.Game;
import hexlet.code.utils.RandomNumberGenerator;

public class Even implements Game {
    public int getNumber() {
        return 2;
    }

    public String getName() {
        return "Even";
    }

    public String getRule() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    public String getQuestion() {
        int number = RandomNumberGenerator.generate();
        return String.valueOf(number);
    }

    public String getCorrectAnswer(String question) {
        int number = Integer.valueOf(question);
        return isEvenNumber(number) ? "yes" : "no";
    }

    private boolean isEvenNumber(int number) {
        return number % 2 == 0;
    }
}
