package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.question.Judge;
import baseball.question.JudgeNumbers;
import baseball.question.ScoreCount;
import org.junit.jupiter.api.Test;

public class JudgeTest {
    @Test
    void 판정_3스트라이크() {
        ScoreCount scoreCount = Judge.call(
                JudgeNumbers.of(123),
                JudgeNumbers.of(123)
        );

        assertScoreCount(scoreCount, 3, 0, 0);
    }

    @Test
    void 판정_3아웃() {
        ScoreCount scoreCount = Judge.call(
                JudgeNumbers.of(123),
                JudgeNumbers.of(789)
        );

        assertScoreCount(scoreCount, 0, 0, 3);
    }

    @Test
    void 판정_스트라이크() {
        ScoreCount scoreCount = Judge.call(
                JudgeNumbers.of(123),
                JudgeNumbers.of(189)
        );

        assertScoreCount(scoreCount, 1, 0, 2);
    }

    @Test
    void 판정_볼() {
        ScoreCount scoreCount = Judge.call(
                JudgeNumbers.of(123),
                JudgeNumbers.of(417)
        );

        assertScoreCount(scoreCount, 0, 1, 2);
    }

    @Test
    void 판정_스트라이크_볼() {
        ScoreCount scoreCount = Judge.call(
                JudgeNumbers.of(123),
                JudgeNumbers.of(413)
        );

        assertScoreCount(scoreCount, 1, 1, 1);
    }

    private void assertScoreCount(
            ScoreCount scoreCount, int expectedStrikeCount, int expectedBallCount, int expectedOutCount
    ) {
        assertThat(scoreCount.strike).isEqualTo(expectedStrikeCount);
        assertThat(scoreCount.ball).isEqualTo(expectedBallCount);
        assertThat(scoreCount.out).isEqualTo(expectedOutCount);
    }
}
