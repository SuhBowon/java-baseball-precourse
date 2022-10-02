package baseball.controller;

import baseball.input.ConsoleContinueValidator;
import baseball.input.ConsoleLineReader;
import baseball.output.ConsoleWriter;
import baseball.question.Judge;
import baseball.question.JudgeNumbers;
import baseball.question.ScoreCount;

public class Game {
    private final JudgeNumbers questionJudgeNumbers;
    private boolean keepContinue;

    public Game(JudgeNumbers questionJudgeNumbers) {
        this.questionJudgeNumbers = questionJudgeNumbers;
        this.keepContinue = false;
    }

    public void start() throws IllegalArgumentException {
        this.handleQuestion();
        this.handleContinue();
    }

    public boolean needContinue() {
        return this.keepContinue;
    }

    private void handleQuestion() throws IllegalArgumentException {
        ScoreCount scoreCount;
        do {
            ConsoleWriter.printQuestion();
            String input = ConsoleLineReader.read();
            scoreCount = Judge.call(questionJudgeNumbers, JudgeNumbers.of(input));
            ConsoleWriter.printJudgeResult(scoreCount);
        } while (scoreCount.strike != 3);
    }

    private void handleContinue() throws IllegalArgumentException {
        ConsoleWriter.printContinue();
        String input = ConsoleLineReader.read();
        ConsoleContinueValidator.assertValid(input);

        this.keepContinue = Integer.parseInt(input) == 1;
    }
}
