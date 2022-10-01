package baseball.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class ConsoleLineReader {
    public static String read() throws IllegalArgumentException {
        try {
            return Console.readLine();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException();
        }
    }
}
