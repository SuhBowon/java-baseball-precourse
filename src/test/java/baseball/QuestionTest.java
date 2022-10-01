package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.question.JudgeNumbers;
import baseball.question.Question;
import org.junit.jupiter.api.Test;

public class QuestionTest {
    @Test
    void 문제_랜덤_생성_범위_유효() {
        for (int i = 0; i < 10000; i++) {
            Question question = new Question();
            JudgeNumbers judgeNumbers = question.judgeNumbers;

            assertJudgeable(judgeNumbers.first);
            assertJudgeable(judgeNumbers.middle);
            assertJudgeable(judgeNumbers.last);
        }
    }

    @Test
    void 문제_랜덤_생성_중복_없음() {
        for (int i = 0; i < 10000; i++) {
            Question question = new Question();
            JudgeNumbers judgeNumbers = question.judgeNumbers;

            assertThat(judgeNumbers.first)
                    .isNotEqualTo(judgeNumbers.middle)
                    .isNotEqualTo(judgeNumbers.last);
        }
    }

    private void assertJudgeable(int number) {
        assertThat(number).isGreaterThan(0).isLessThan(10);
    }
}
