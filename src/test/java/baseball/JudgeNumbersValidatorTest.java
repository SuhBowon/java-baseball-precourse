package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.question.JudgeNumbersValidator;
import org.junit.jupiter.api.Test;

public class JudgeNumbersValidatorTest {
    @Test
    void 인식_가능_확인_문자열() {
        assertThat(JudgeNumbersValidator.isAcceptable("123")).isTrue();
    }

    @Test
    void 인식_가능_확인_숫자() {
        assertThat(JudgeNumbersValidator.isAcceptable(123)).isTrue();
    }

    @Test
    void 인식_예외_길이_3_아님() {
        String[] errorStrings = new String[]{"", "2", "12", "1234"};
        this.assertNotAcceptableStringsThrowException(errorStrings);
    }

    @Test
    void 인식_예외_값_중복() {
        String[] errorStrings = new String[]{"111", "112", "121", "211"};
        this.assertNotAcceptableStringsThrowException(errorStrings);
    }

    @Test
    void 인식_예외_각_자리_숫자_아님() {
        String[] errorStrings = new String[]{"abc", "ㄱㄴㄷ", "+12", "-12", "12L", "1.2"};
        this.assertNotAcceptableStringsThrowException(errorStrings);
    }

    @Test
    void 인식_예외_각_자리_숫자_범위_벗어남() {
        String[] errorStrings = new String[]{"000", "001", "010", "100", "011", "101", "110"};
        this.assertNotAcceptableStringsThrowException(errorStrings);
    }

    private void assertNotAcceptableStringsThrowException(String[] errorStrings) {
        for (String errorString : errorStrings) {
            assertThatThrownBy(() -> JudgeNumbersValidator.assertValid(errorString))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
