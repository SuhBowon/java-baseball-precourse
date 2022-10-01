package baseball.question;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Question {
    public final JudgeNumbers judgeNumbers;

    public Question() {
        this.judgeNumbers = JudgeNumbers.of(this.getRandom());
    }

    private int getRandom() {
        int pickedNumber;
        do {
            pickedNumber = Randoms.pickNumberInRange(111, 999);
        } while (this.hasZero(pickedNumber) || this.hasDuplicated(pickedNumber));

        return pickedNumber;
    }

    private boolean hasZero(int number) {
        return String.valueOf(number).contains("0");
    }

    private boolean hasDuplicated(int number) {
        Set<String> set = new HashSet<>();
        String[] numberElements = String.valueOf(number).split("");
        Collections.addAll(set, numberElements);
        return set.size() != numberElements.length;
    }
}
