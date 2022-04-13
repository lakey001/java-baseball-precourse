package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class BaseballGame {
    private List<Integer> randomNumbers;

    public BaseballGame() {
        this.randomNumbers = Randoms.pickUniqueNumbersInRange(1, 9, 3);
    }

    public List<Integer> getRandomNumbers() {
        return randomNumbers;
    }
}
