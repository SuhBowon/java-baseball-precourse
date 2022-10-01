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
        } while (!JudgeNumbers.isJudgeable(pickedNumber));

        return pickedNumber;
    }
}
