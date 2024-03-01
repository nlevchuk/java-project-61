package hexlet.code.utils;

public class RandomNumberGenerator {
    public static int generate(int length) {
        int randomNumber = (int) (Math.random() * length);
        return randomNumber;
    }

    public static int generate() {
        return generate(100);
    }
}
