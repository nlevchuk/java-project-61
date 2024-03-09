package hexlet.code;

import java.util.Scanner;
import java.util.InputMismatchException;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.Gcd;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        showGameList();
        System.out.print("Your choice: ");

        int gameNumber = EXIT_NUMBER;
        try {
            gameNumber = chooseGameNumber(scanner);
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Type one of the numbers above.");
            scanner.close();
            return;
        }

        System.out.println(""); // Add an empty line after the your-choice line

        if (gameNumber == EXIT_NUMBER) {
            System.out.println("Goodbye");
            scanner.close();
            return;
        }

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");

        runGame(gameNumber, userName, scanner);

        scanner.close();
    }

    // Constants
    private static final int GAME_ITERATIONS = 3;
    private static final int EXIT_NUMBER = 0;
    private static final int GREET_NUMBER = 1;
    private static final int EVEN_NUMBER = 2;
    private static final int CALC_NUMBER = 3;
    private static final int GCD_NUMBER = 4;
    private static final int PROGRESSION_NUMBER = 5;
    private static final int PRIME_NUMBER = 6;

    private static void showGameList() {
        System.out.println(GREET_NUMBER + " - Greet");
        System.out.println(EVEN_NUMBER + " - Even");
        System.out.println(CALC_NUMBER + " - Calc");
        System.out.println(GCD_NUMBER + " - GCD");
        System.out.println(PROGRESSION_NUMBER + " - Progression");
        System.out.println(PRIME_NUMBER + " - Prime");
        System.out.println(EXIT_NUMBER + " - Exit");
    }

    private static int chooseGameNumber(Scanner scanner) throws InputMismatchException {
        int gameNumber = scanner.nextInt();
        return gameNumber;
    }

    private static void runGame(int gameNumber, String userName, Scanner scanner) {
        switch (gameNumber) {
            case GREET_NUMBER:
                //noop
                break;
            case EVEN_NUMBER:
                Even.run(GAME_ITERATIONS, userName, scanner);
                break;
            case CALC_NUMBER:
                Calc.run(GAME_ITERATIONS, userName, scanner);
                break;
            case GCD_NUMBER:
                Gcd.run(GAME_ITERATIONS, userName, scanner);
                break;
            case PROGRESSION_NUMBER:
                Progression.run(GAME_ITERATIONS, userName, scanner);
                break;
            case PRIME_NUMBER:
                Prime.run(GAME_ITERATIONS, userName, scanner);
                break;
            default:
                System.out.println("Unknown game");
        }
    }
}
