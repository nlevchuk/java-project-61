package hexlet.code.games;

import hexlet.code.Game;
import hexlet.code.utils.RandomNumberGenerator;

public class Calc implements Game {
    public String getRule() {
        return "What is the result of the expression?";
    }

    public String getQuestion() {
        return buildExpression();
    }

    public String getCorrectAnswer(String question) {
        return parseExpression(question);
    }

    private String buildExpression() {
        int firstOperand = RandomNumberGenerator.generate(10);
        int secondOperand = RandomNumberGenerator.generate(10);
        char operation = getOperation();

        return firstOperand + " " + operation + " " + secondOperand;
    }

    private String parseExpression(String expr) {
        String[] parts = expr.split(" ");
        int firstOperand = Integer.valueOf(parts[0]);
        char operation = parts[1].charAt(0);
        int secondOperand = Integer.valueOf(parts[2]);

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

        return operations[operationNumber];
    }
}
