package baseball.question;

import camp.nextstep.edu.missionutils.Randoms;

public class Question {
    public final JudgeNumbers judgeNumbers;

    public Question() {
        this.judgeNumbers = JudgeNumbers.of(this.getRandom());
    }

    private String getRandom() {
        String pickedNumber;
        do {
            pickedNumber = this.getCandidateNumber();
        } while (!JudgeNumbersValidator.isAcceptable(pickedNumber));

        return pickedNumber;
    }

    private String getCandidateNumber() {
        StringBuilder pickedNumber = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            pickedNumber.append(Randoms.pickNumberInRange(1, 9));
        }
        return pickedNumber.toString();
    }
}
