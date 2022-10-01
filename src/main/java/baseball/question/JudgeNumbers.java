package baseball.question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class JudgeNumbers {
    public final int first;
    public final int middle;
    public final int last;

    private JudgeNumbers(int first, int middle, int last) {
        this.first = first;
        this.middle = middle;
        this.last = last;
    }

    public static JudgeNumbers of(int judgeNumber) {
        return JudgeNumbers.of(String.valueOf(judgeNumber));
    }

    public static JudgeNumbers of(String judgeString) {
        JudgeNumbers.assertValid(judgeString);

        String[] judgeElements = judgeString.split("");
        int first = Integer.parseInt(judgeElements[0]);
        int middle = Integer.parseInt(judgeElements[1]);
        int last = Integer.parseInt(judgeElements[2]);

        return new JudgeNumbers(first, middle, last);
    }

    public static boolean isJudgeable(int judgeNumber) {
        return JudgeNumbers.isJudgeable(String.valueOf(judgeNumber));
    }

    public static boolean isJudgeable(String judgeString) {
        return isLength3(judgeString)
                && isElementsUnique(judgeString)
                && isElementsNumber(judgeString)
                && isElementsValidNumberRange(judgeString);
    }

    private static void assertValid(String judgeString) throws IllegalArgumentException {
        if (!JudgeNumbers.isJudgeable(judgeString)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isLength3(String judgeString) {
        return judgeString.length() == 3;
    }

    private static boolean isElementsUnique(String judgeString) {
        String[] inputChars = getInputChars(judgeString);
        Set<String> set = new HashSet<>(Arrays.asList(inputChars));
        return set.size() == inputChars.length;
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    private static boolean isElementsNumber(String input) {
        try {
            Integer.parseUnsignedInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isElementsValidNumberRange(String input) {
        List<Boolean> validNumberRanges = new ArrayList<>();
        for (String inputChar : getInputChars(input)) {
            validNumberRanges.add(
                    JudgeNumbers.isValidNumberRange(
                            Integer.parseInt(inputChar)
                    )
            );
        }
        return !validNumberRanges.contains(false);
    }

    private static boolean isValidNumberRange(int number) {
        return number > 0 && number < 10;
    }

    private static String[] getInputChars(String input) {
        return input.split("");
    }

    public boolean has(int number) {
        return number == this.first
                || number == this.middle
                || number == this.last;
    }

    @Override
    public boolean equals(Object obj) {
        return Objects.equals(this.toString(), obj.toString())
                && getClass() == obj.getClass();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()
                + String.format("[first=%s, middle=%s, last=%s]", first, middle, last);
    }
}
