package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.question.JudgeNumbers;
import org.junit.jupiter.api.Test;

public class JudgeNumbersTest {
    @Test
    void 변환_문자열() {
        assertJudgeNumbers(JudgeNumbers.of("123"), 1, 2, 3);
    }

    @Test
    void 변환_숫자() {
        assertJudgeNumbers(JudgeNumbers.of(123), 1, 2, 3);
    }

    private void assertJudgeNumbers(
            JudgeNumbers judgeNumbers, int expectedFirst, int expectedMiddle, int expectedLast
    ) {
        assertThat(judgeNumbers.first).isEqualTo(expectedFirst);
        assertThat(judgeNumbers.middle).isEqualTo(expectedMiddle);
        assertThat(judgeNumbers.last).isEqualTo(expectedLast);
    }
}
