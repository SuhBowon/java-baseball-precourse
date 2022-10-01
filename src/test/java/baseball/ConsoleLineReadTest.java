package baseball;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.input.ConsoleLineReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Test;

public class ConsoleLineReadTest {
    @Test
    void 콘솔_라인_읽기() {
        String expected = "123";
        this.setInput(expected);
        String actual = ConsoleLineReader.read();

        assertEquals(expected, actual);
    }

    @Test
    void 콘솔_라인_읽기_예외_빈_문자열() {
        String expected = "";
        this.setInput(expected);

        assertThatThrownBy(() -> {
            ConsoleLineReader.read();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    private void setInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}
