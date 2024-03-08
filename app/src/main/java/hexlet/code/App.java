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
        // Constants
        final int gameIterations = 3;
        final int exitNumber = 0;
        final int greetNumber = 1;
        final int evenNumber = 2;
        final int calcNumber = 3;
        final int gcdNumber = 4;
        final int progressionNumber = 5;
        final int primeNumber = 6;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        System.out.println(greetNumber + " - Greet");
        System.out.println(evenNumber + " - Even");
        System.out.println(calcNumber + " - Calc");
        System.out.println(gcdNumber + " - GCD");
        System.out.println(progressionNumber + " - Progression");
        System.out.println(primeNumber + " - Prime");
        System.out.println(exitNumber + " - Exit");
        System.out.print("Your choice: ");

        int gameNumber = exitNumber;
        try {
            gameNumber = chooseGameNumber(scanner);
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Type one of the numbers above.");
            scanner.close();
            return;
        }

        System.out.println(""); // Add an empty line after the your-choice line

        if (gameNumber == exitNumber) {
            System.out.println("Goodbye");
            scanner.close();
            return;
        }

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");

        switch (gameNumber) {
            case greetNumber:
                //noop
                break;
            case evenNumber:
                Even.run(gameIterations, userName, scanner);
                break;
            case calcNumber:
                Calc.run(gameIterations, userName, scanner);
                break;
            case gcdNumber:
                Gcd.run(gameIterations, userName, scanner);
                break;
            case progressionNumber:
                Progression.run(gameIterations, userName, scanner);
                break;
            case primeNumber:
                Prime.run(gameIterations, userName, scanner);
                break;
            default:
                System.out.println("Unknown game");
        }

        scanner.close();
    }

    private static int chooseGameNumber(Scanner scanner) throws InputMismatchException {
        int gameNumber = scanner.nextInt();
        return gameNumber;
    }
}
