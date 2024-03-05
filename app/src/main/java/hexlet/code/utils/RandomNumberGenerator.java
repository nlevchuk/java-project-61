package hexlet.code.utils;

public class RandomNumberGenerator {
    public static int generate(int length) {
        int randomNumber = (int) (Math.random() * length);
        return randomNumber + 1; // to avoid 0
    }

    public static int generate() {
        return generate(100);
    }
}
