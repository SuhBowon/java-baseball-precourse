package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    void 변환_가능_확인_문자열() {
        assertThat(JudgeNumbers.isJudgeable("123")).isTrue();
    }

    @Test
    void 변환_가능_확인_숫자() {
        assertThat(JudgeNumbers.isJudgeable(123)).isTrue();
    }

    @Test
    void 변환_예외_길이_3_아님() {
        String[] errorStrings = new String[]{"", "2", "12", "1234"};
        this.assertErrorInputsThrowException(errorStrings);
    }

    @Test
    void 변환_예외_값_중복() {
        String[] errorStrings = new String[]{"111", "112", "121", "211"};
        this.assertErrorInputsThrowException(errorStrings);
    }

    @Test
    void 변환_예외_각_자리_숫자_아님() {
        String[] errorStrings = new String[]{"abc", "ㄱㄴㄷ", "+12", "-12", "12L", "1.2"};
        this.assertErrorInputsThrowException(errorStrings);
    }

    @Test
    void 변환_예외_각_자리_숫자_범위_벗어남() {
        String[] errorStrings = new String[]{"000", "001", "010", "100", "011", "101", "110"};
        this.assertErrorInputsThrowException(errorStrings);
    }

    private void assertErrorInputsThrowException(String[] errorStrings) {
        for (String errorString : errorStrings) {
            assertThatThrownBy(() -> JudgeNumbers.of(errorString))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    private void assertJudgeNumbers(
            JudgeNumbers judgeNumbers, int expectedFirst, int expectedMiddle, int expectedLast
    ) {
        assertThat(judgeNumbers.first).isEqualTo(expectedFirst);
        assertThat(judgeNumbers.middle).isEqualTo(expectedMiddle);
        assertThat(judgeNumbers.last).isEqualTo(expectedLast);
    }
}
