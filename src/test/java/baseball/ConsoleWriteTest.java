package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.output.ConsoleWriter;
import baseball.question.ScoreCount;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConsoleWriteTest {
    private OutputStream out;

    @BeforeEach
    protected final void init() {
        this.out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @Test
    void 콘솔_출력_진행_질의() {
        ConsoleWriter.printQuestion();
        assertThat(out.toString()).isEqualTo(ConsoleWriter.QUESTION_MESSAGE);
    }

    @Test
    void 콘솔_출력_종료_질의() {
        ConsoleWriter.printContinue();
        assertThat(out.toString()).isEqualTo(ConsoleWriter.CONTINUE_MESSAGE);
    }

    @Test
    void 콘솔_출력_판정_3스트라이크() {
        int strikeCount = 3;
        int ballCount = 0;
        int outCount = 0;
        this.printJudgeResult(strikeCount, ballCount, outCount);
        assertThat(out.toString()).isEqualTo(strikeCount + ConsoleWriter.JUDGED_STRIKE + "\n");
    }

    @Test
    void 콘솔_출력_판정_3아웃() {
        int strikeCount = 0;
        int ballCount = 0;
        int outCount = 3;
        this.printJudgeResult(strikeCount, ballCount, outCount);
        assertThat(out.toString()).isEqualTo(ConsoleWriter.JUDGED_3_OUT + "\n");
    }

    @Test
    void 콘솔_출력_판정_스트라이크() {
        int strikeCount = 1;
        int ballCount = 0;
        int outCount = 2;
        this.printJudgeResult(strikeCount, ballCount, outCount);
        assertThat(out.toString()).isEqualTo(strikeCount + ConsoleWriter.JUDGED_STRIKE + "\n");
    }

    @Test
    void 콘솔_출력_판정_볼() {
        int strikeCount = 0;
        int ballCount = 1;
        int outCount = 2;
        this.printJudgeResult(strikeCount, ballCount, outCount);
        assertThat(out.toString()).isEqualTo(ballCount + ConsoleWriter.JUDGED_BALL + "\n");
    }

    @Test
    void 콘솔_출력_판정_볼_스트라이크() {
        int strikeCount = 1;
        int ballCount = 2;
        int outCount = 0;
        this.printJudgeResult(strikeCount, ballCount, outCount);
        assertThat(out.toString())
                .isEqualTo(ballCount + ConsoleWriter.JUDGED_BALL
                        + " " + strikeCount + ConsoleWriter.JUDGED_STRIKE + "\n");
    }

    private void printJudgeResult(int strikeCount, int ballCount, int outCount) {
        ScoreCount scoreCount = new ScoreCount(strikeCount, ballCount, outCount);
        ConsoleWriter.printJudgeResult(scoreCount);
    }
}
