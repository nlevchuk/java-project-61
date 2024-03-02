package hexlet.code;

import java.util.Scanner;
import java.util.InputMismatchException;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.Gcd;

class App {
    public static void main(String[] args) {
        // Constants
        final int exitNumber = 0;
        final int greetNumber = 1;
        final int evenGameNumber = 2;
        final int calcGameNumber = 3;
        final int gcdGameNumber = 4;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        System.out.println(greetNumber + " - Greet");
        System.out.println(evenGameNumber + " - Even");
        System.out.println(calcGameNumber + " - Calc");
        System.out.println(gcdGameNumber + " - GCD");
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

        Game currentGame;
        switch (gameNumber) {
            case greetNumber:
                // noop
                break;
            case evenGameNumber:
                currentGame = new Even();
                Engine.runGame(currentGame, userName, scanner);
                break;
            case calcGameNumber:
                currentGame = new Calc();
                Engine.runGame(currentGame, userName, scanner);
                break;
            case gcdGameNumber:
                currentGame = new Gcd();
                Engine.runGame(currentGame, userName, scanner);
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
