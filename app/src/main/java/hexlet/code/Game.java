package hexlet.code;

public interface Game {
    int getNumber();
    String getName();
    String getRule();
    String getQuestion();
    String getCorrectAnswer(String question);
}
