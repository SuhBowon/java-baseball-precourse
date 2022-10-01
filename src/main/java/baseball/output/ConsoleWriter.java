package baseball.output;

import baseball.question.ScoreCount;

public class ConsoleWriter {
    public static final String QUESTION_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String CONTINUE_MESSAGE =
            "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
                    + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";

    public static final String JUDGED_BALL = "볼";
    public static final String JUDGED_STRIKE = "스트라이크";
    public static final String JUDGED_3_OUT = "낫싱";

    public static void printQuestion() {
        System.out.print(QUESTION_MESSAGE);
    }

    public static void printContinue() {
        System.out.print(CONTINUE_MESSAGE);
    }

    public static void printJudgeResult(ScoreCount scoreCount) {
        System.out.print(ConsoleWriter.getJudgeMessage(scoreCount));
    }

    private static String getJudgeMessage(ScoreCount scoreCount) {
        return String.join(" ",
                getBallMessage(scoreCount),
                getStrikeMessage(scoreCount),
                get3OutMessage(scoreCount)
        ).trim() + "\n";
    }

    private static String getBallMessage(ScoreCount scoreCount) {
        return scoreCount.ball > 0 ? scoreCount.ball + ConsoleWriter.JUDGED_BALL : "";
    }

    private static String getStrikeMessage(ScoreCount scoreCount) {
        return scoreCount.strike > 0 ? scoreCount.strike + ConsoleWriter.JUDGED_STRIKE : "";
    }

    private static String get3OutMessage(ScoreCount scoreCount) {
        return scoreCount.out == 3 ? ConsoleWriter.JUDGED_3_OUT : "";
    }
}
