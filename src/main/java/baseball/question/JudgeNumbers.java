package baseball.question;

import java.util.Objects;

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
