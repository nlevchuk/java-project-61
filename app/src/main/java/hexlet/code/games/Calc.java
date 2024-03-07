package hexlet.code.games;

import hexlet.code.Game;
import hexlet.code.utils.RandomNumberGenerator;

public class Calc implements Game {
    public int getNumber() {
        return 3;
    }

    public String getName() {
        return "Calc";
    }

    public String getRule() {
        return "What is the result of the expression?";
    }

    public String getQuestion() {
        return buildExpression();
    }

    public String getCorrectAnswer(String question) {
        String[] parts = question.split(" ");
        char operation = parts[1].charAt(0);
        int firstOperand = Integer.valueOf(parts[0]);
        int secondOperand = Integer.valueOf(parts[2]);

        return calculateExpression(operation, firstOperand, secondOperand);
    }

    private String buildExpression() {
        int firstOperand = RandomNumberGenerator.generate(10);
        int secondOperand = RandomNumberGenerator.generate(10);
        char operation = getOperation();

        return firstOperand + " " + operation + " " + secondOperand;
    }

    private String calculateExpression(char operation, int firstOperand, int secondOperand) {
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

        return String.valueOf(result);
    }

    private char getOperation() {
        final char[] operations = {'+', '-', '*'};
        int operationNumber = RandomNumberGenerator.generate(operations.length);

        return operations[operationNumber - 1];
    }
}
