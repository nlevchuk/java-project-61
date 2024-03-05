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
        final int exitNumber = 0;
        final int greetNumber = 1;
        final Game[] games = initGames();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        System.out.println(greetNumber + " - Greet");
        for (Game game : games) {
            System.out.println(game.getNumber() + " - " + game.getName());
        }
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

        Game currentGame = getGame(gameNumber, games);
        if (gameNumber != greetNumber && currentGame == null) {
            System.out.println("The provided number is not included in the set of numbers listed above.");
            scanner.close();
            return;
        }

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");

        if (currentGame != null) {
            Engine.runGame(currentGame, userName, scanner);
        }

        scanner.close();
    }

    private static Game[] initGames() {
        final Game evenGame = new Even();
        final Game calcGame = new Calc();
        final Game gcdGame = new Gcd();
        final Game progressionGame = new Progression();
        final Game primeGame = new Prime();

        // How effective is it in terms of memory?
        Game[] games = {
            evenGame,
            calcGame,
            gcdGame,
            progressionGame,
            primeGame
        };

        return games;
    }

    private static int chooseGameNumber(Scanner scanner) throws InputMismatchException {
        int gameNumber = scanner.nextInt();
        return gameNumber;
    }

    private static Game getGame(int gameNumber, Game[] games) {
        for (Game game : games) {
            if (game.getNumber() == gameNumber) {
                return game;
            }
        }
        return null;
    }
}
