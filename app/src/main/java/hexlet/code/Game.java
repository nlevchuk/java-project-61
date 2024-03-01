package hexlet.code;

public interface Game {
    String getRule();
    String getQuestion();
    String getCorrectAnswer(String question);
}
