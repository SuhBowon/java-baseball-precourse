package baseball;

import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.assertTrue;

import baseball.question.Question;
import org.junit.jupiter.api.Test;

public class QuestionTest {
    @Test
    void 문제_출제() {
        for (int i = 0; i < 10000; i++) {
            this.assertNotThrowCreateQuestion();
        }
    }

    private void assertNotThrowCreateQuestion() {
        try {
            new Question();
            assertTrue(Boolean.TRUE);
        } catch (IllegalArgumentException e) {
            fail("Generating random numbers error occurred.");
        }
    }
}
