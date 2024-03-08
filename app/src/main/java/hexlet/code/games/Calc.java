package hexlet.code.games;

import java.util.Scanner;

import hexlet.code.Engine;
import hexlet.code.utils.RandomNumberGenerator;

public class Calc {
    public static void run(int iterations, String userName, Scanner scanner) {
        System.out.println("What is the result of the expression?");

        final int begin = 1;
        final int end = 10;
        String[] questions = new String[iterations];
        String[] correctAnswers = new String[iterations];
        for (int i = 0; i < iterations; i++) {
            int firstOperand = RandomNumberGenerator.generateBetween(begin, end);
            int secondOperand = RandomNumberGenerator.generateBetween(begin, end);
            char operation = getOperation();

            questions[i] = firstOperand + " " + operation + " " + secondOperand;
            int correctAnswer = calculateExpression(operation, firstOperand, secondOperand);
            correctAnswers[i] = String.valueOf(correctAnswer);
        }

        Engine.runGame(questions, correctAnswers, userName, scanner);
    }

    private static char getOperation() {
        int begin = 0;
        int end = 2;
        int operationNumber = RandomNumberGenerator.generateBetween(begin, end);
        char[] operations = {'+', '-', '*'};

        return operations[operationNumber];
    }

    private static int calculateExpression(char operation, int firstOperand, int secondOperand) {
        int result = 0;

        switch (operation) {
            case '+':
                result = firstOperand + secondOperand;
                break;
            case '-':
                result = firstOperand - secondOperand;
                break;
            case '*':
                result = firstOperand * secondOperand;
                break;
            default:
                System.out.println("Unknown operation");
        }

        return result;
    }
}
