package baseball.question;

public class Judge {
    public static ScoreCount call(JudgeNumbers answerJudgeNumbers, JudgeNumbers questionJudgeNumbers) {
        int strikeCount = Judge.getStrikeCount(answerJudgeNumbers, questionJudgeNumbers);
        int ballCount = Judge.getBallCount(answerJudgeNumbers, questionJudgeNumbers);
        int outCount = Judge.getOutCount(answerJudgeNumbers, questionJudgeNumbers);
        return new ScoreCount(strikeCount, ballCount, outCount);
    }

    private static int getStrikeCount(JudgeNumbers answerJudgeNumbers, JudgeNumbers questionJudgeNumbers) {
        return Judge.getTotalCount(
                Judge.isFirstStrike(answerJudgeNumbers, questionJudgeNumbers),
                Judge.isMiddleStrike(answerJudgeNumbers, questionJudgeNumbers),
                Judge.isLastStrike(answerJudgeNumbers, questionJudgeNumbers)
        );
    }

    private static boolean isFirstStrike(JudgeNumbers answerJudgeNumbers, JudgeNumbers questionJudgeNumbers) {
        return answerJudgeNumbers.first == questionJudgeNumbers.first;
    }

    private static boolean isMiddleStrike(JudgeNumbers answerJudgeNumbers, JudgeNumbers questionJudgeNumbers) {
        return answerJudgeNumbers.middle == questionJudgeNumbers.middle;
    }

    private static boolean isLastStrike(JudgeNumbers answerJudgeNumbers, JudgeNumbers questionJudgeNumbers) {
        return answerJudgeNumbers.last == questionJudgeNumbers.last;
    }

    private static int getBallCount(JudgeNumbers answerJudgeNumbers, JudgeNumbers questionJudgeNumbers) {
        return Judge.getTotalCount(
                Judge.isFirstBall(answerJudgeNumbers, questionJudgeNumbers),
                Judge.isMiddleBall(answerJudgeNumbers, questionJudgeNumbers),
                Judge.isLastBall(answerJudgeNumbers, questionJudgeNumbers)
        );
    }

    private static boolean isFirstBall(JudgeNumbers answerJudgeNumbers, JudgeNumbers questionJudgeNumbers) {
        return Judge.isBall(answerJudgeNumbers.first, questionJudgeNumbers.first, questionJudgeNumbers);
    }

    private static boolean isMiddleBall(JudgeNumbers answerJudgeNumbers, JudgeNumbers questionJudgeNumbers) {
        return Judge.isBall(answerJudgeNumbers.middle, questionJudgeNumbers.middle, questionJudgeNumbers);
    }

    private static boolean isLastBall(JudgeNumbers answerJudgeNumbers, JudgeNumbers questionJudgeNumbers) {
        return Judge.isBall(answerJudgeNumbers.last, questionJudgeNumbers.last, questionJudgeNumbers);
    }

    private static boolean isBall(int testJudgeNumber, int baseJudgeNumber, JudgeNumbers baseJudgeNumbers) {
        return baseJudgeNumbers.has(testJudgeNumber) && testJudgeNumber != baseJudgeNumber;
    }

    private static int getOutCount(JudgeNumbers answerJudgeNumbers, JudgeNumbers questionJudgeNumbers) {
        return Judge.getTotalCount(
                Judge.isFirstOut(answerJudgeNumbers, questionJudgeNumbers),
                Judge.isMiddleOut(answerJudgeNumbers, questionJudgeNumbers),
                Judge.isLastOut(answerJudgeNumbers, questionJudgeNumbers)
        );
    }

    private static boolean isFirstOut(JudgeNumbers answerJudgeNumbers, JudgeNumbers questionJudgeNumbers) {
        return !questionJudgeNumbers.has(answerJudgeNumbers.first);
    }

    private static boolean isMiddleOut(JudgeNumbers answerJudgeNumbers, JudgeNumbers questionJudgeNumbers) {
        return !questionJudgeNumbers.has(answerJudgeNumbers.middle);
    }

    private static boolean isLastOut(JudgeNumbers answerJudgeNumbers, JudgeNumbers questionJudgeNumbers) {
        return !questionJudgeNumbers.has(answerJudgeNumbers.last);
    }

    private static int getTotalCount(boolean isFirst, boolean isMiddle, boolean isLast) {
        int firstCount = isFirst ? 1 : 0;
        int middleCount = isMiddle ? 1 : 0;
        int lastCount = isLast ? 1 : 0;
        return firstCount + middleCount + lastCount;
    }
}
