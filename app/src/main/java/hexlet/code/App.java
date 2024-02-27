package hexlet.code;

import java.util.Scanner;

class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int gameNumber = getGameNumber(scanner);
        selectGame(gameNumber, scanner);

        scanner.close();
    }

    public static int getGameNumber(Scanner scanner) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
        String gameNumber = scanner.next();

        return Integer.valueOf(gameNumber);
    }

    public static void selectGame(int gameNumber, Scanner scanner) {
        switch (gameNumber) {
            case 0:
                System.out.println("Goodbye");
                break;
            case 1:
                System.out.println("Welcome to the Brain Games!");
                Cli.greetings(scanner);
                break;
            default:
                System.out.println("Unknown game number");
                return;
        }
    }
}
