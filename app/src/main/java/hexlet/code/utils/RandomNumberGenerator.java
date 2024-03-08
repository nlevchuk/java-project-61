package hexlet.code.utils;

public class RandomNumberGenerator {
    public static int generateBetween(int begin, int end) {
        int randomNumber = (int) ((Math.random() * (end - begin + 1)) + begin);
        return randomNumber;
    }
}
