package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.input.ConsoleContinueValidator;
import org.junit.jupiter.api.Test;

public class ConsoleContinueValidatorTest {
    @Test
    void 인식_가능_확인_문자열() {
        assertThat(ConsoleContinueValidator.isAcceptable("1")).isTrue();
    }

    @Test
    void 인식_가능_확인_숫자() {
        assertThat(ConsoleContinueValidator.isAcceptable(2)).isTrue();
    }

    @Test
    void 인식_예외_길이_1_아님() {
        String[] errorStrings = new String[]{"", "12", "123", "1234"};
        this.assertErrorInputsThrowException(errorStrings);
    }

    @Test
    void 인식_예외_숫자_아님() {
        String[] errorStrings = new String[]{"a", "ㄱ", "+", "-"};
        this.assertErrorInputsThrowException(errorStrings);
    }

    @Test
    void 인식_예외_숫자_범위_벗어남() {
        String[] errorStrings = new String[]{"0", "3", "9"};
        this.assertErrorInputsThrowException(errorStrings);
    }

    private void assertErrorInputsThrowException(String[] errorStrings) {
        for (String errorString : errorStrings) {
            assertThatThrownBy(() -> ConsoleContinueValidator.assertValid(errorString))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
