package hexlet.code.games;

import java.util.StringJoiner;

import hexlet.code.Game;
import hexlet.code.utils.RandomNumberGenerator;

public class Progression implements Game {
    private final String unknownTermSign = "..";
    private final int sequenceLength = 10;

    public String getRule() {
        return "What number is missing in the progression?";
    }

    public String getQuestion() {
        return buildArithmeticSequence();
    }

    public String getCorrectAnswer(String question) {
        String[] sequence = question.split(" ");

        return findUnknownTerm(sequence);
    }

    private String buildArithmeticSequence() {
        final int initialTerm = RandomNumberGenerator.generate(10);
        final int commonDiff = RandomNumberGenerator.generate(10);
        final int unknownTermIndex = RandomNumberGenerator.generate(10);

        int term;
        StringJoiner sequenceBuilder = new StringJoiner(" ");
        for (int n = 1; n <= sequenceLength; n++) {
            if (n == unknownTermIndex) {
                sequenceBuilder.add(unknownTermSign);
            } else {
                term = calculateSequenceTerm(initialTerm, commonDiff, n);
                sequenceBuilder.add(String.valueOf(term));
            }
        }

        return sequenceBuilder.toString();
    }

    private int calculateSequenceTerm(int initialTerm, int commonDiff, int n) {
        return initialTerm + (n - 1) * commonDiff;
    }

    // The given assignment allows for any term to be unknown.
    // Therefore, we are unable to use the same formula to calculate the sequence term
    // because the initial term may be unknown.
    private String findUnknownTerm(String[] sequence) {
        int unknownArrayIndex = getUnknownArrayIndex(sequence);
        int unknownTerm;

        // If the array's index is greater than 3, it means that there are at least two preceding terms.
        // Otherwise, we have at least two subsequent terms.
        if (unknownArrayIndex > 3) {
            unknownTerm = findUnknownTermBasedOnPrecedingTerms(sequence, unknownArrayIndex);
        } else {
            unknownTerm = findUnknownTermBasedOnSubsequentTerms(sequence, unknownArrayIndex);
        }

        return String.valueOf(unknownTerm);
    }

    private int getUnknownArrayIndex(String[] sequence) {
        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i].equals(unknownTermSign)) {
                return i;
            }
        }

        return 0;
    }

    private int findUnknownTermBasedOnPrecedingTerms(String[] sequence, int unknownArrayIndex) {
        int preUnknownTerm = Integer.valueOf(sequence[unknownArrayIndex - 1]);
        int prePreUnknownTerm = Integer.valueOf(sequence[unknownArrayIndex - 2]);
        int commonDiff = preUnknownTerm - prePreUnknownTerm;

        return preUnknownTerm + commonDiff;
    }

    private int findUnknownTermBasedOnSubsequentTerms(String[] sequence, int unknownArrayIndex) {
        int postUnknownTerm = Integer.valueOf(sequence[unknownArrayIndex + 1]);
        int postPostPreUnknownTerm = Integer.valueOf(sequence[unknownArrayIndex + 2]);
        int commonDiff = postPostPreUnknownTerm - postUnknownTerm;

        return postUnknownTerm - commonDiff;
    }
}
