package baseball.question;

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
        String[] judgeElements = judgeString.split("");
        int first = Integer.parseInt(judgeElements[0]);
        int middle = Integer.parseInt(judgeElements[1]);
        int last = Integer.parseInt(judgeElements[2]);

        return new JudgeNumbers(first, middle, last);
    }
}
