package baseball.input;

public class ConsoleContinueValidator {
    public static boolean isAcceptable(int continueNumber) {
        return ConsoleContinueValidator.isAcceptable(String.valueOf(continueNumber));
    }

    public static boolean isAcceptable(String continueString) {
        return ConsoleContinueValidator.isLength1(continueString)
                && ConsoleContinueValidator.isElementsNumber(continueString)
                && ConsoleContinueValidator.isElementsValidNumberRange(continueString);
    }

    public static void assertValid(String continueString) throws IllegalArgumentException {
        if (!ConsoleContinueValidator.isAcceptable(continueString)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isLength1(String continueString) {
        return continueString.length() == 1;
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    private static boolean isElementsNumber(String continueString) {
        try {
            Integer.parseUnsignedInt(continueString);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isElementsValidNumberRange(String continueString) {
        int inputCharNumber = Integer.parseInt(continueString);
        return inputCharNumber == 1 || inputCharNumber == 2;
    }
}
