package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class BaseballGame {
    private List<Integer> randomNumbers;
    private boolean gameEnd;

    public BaseballGame() {
        this.randomNumbers = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        this.gameEnd = false;
    }

    public List<Integer> getRandomNumbers() {
        return randomNumbers;
    }

    public boolean isGameEnd() {
        return gameEnd;
    }
}
