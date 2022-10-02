package baseball.question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JudgeNumbersValidator {
    public static boolean isAcceptable(int judgeNumber) {
        return JudgeNumbersValidator.isAcceptable(String.valueOf(judgeNumber));
    }

    public static boolean isAcceptable(String judgeString) {
        return isLength3(judgeString)
                && isElementsUnique(judgeString)
                && isElementsNumber(judgeString)
                && isElementsValidNumberRange(judgeString);
    }

    public static void assertValid(String judgeString) throws IllegalArgumentException {
        if (!JudgeNumbersValidator.isAcceptable(judgeString)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isLength3(String judgeString) {
        return judgeString.length() == 3;
    }

    private static boolean isElementsUnique(String judgeString) {
        String[] inputChars = JudgeNumbersValidator.getInputChars(judgeString);
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
        for (String inputChar : JudgeNumbersValidator.getInputChars(input)) {
            validNumberRanges.add(
                    JudgeNumbersValidator.isValidNumberRange(
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
}
