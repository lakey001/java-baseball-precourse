package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class BaseballGame {
    private List<Integer> randomNumbers;
    private boolean gameEnd;
    private int strikeCounter;
    private int ballCounter;

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

    public int getStrikeCounter() {
        return strikeCounter;
    }

    public int getBallCounter() {
        return ballCounter;
    }

    public void proceed(List<Integer> inputNumbers) {
        strikeCounter = 0;
        ballCounter = 0;
        for(int i = 0; i < 3; i++){
            updateGuessState(inputNumbers.get(i), i);
        }
        if(strikeCounter == 3){
            gameEnd = true;
        }
    }

    private void updateGuessState(Integer number, int idx) {
        if (randomNumbers.get(idx) == number) {
            strikeCounter ++;
            return;
        }
        if (randomNumbers.contains(number)) {
            ballCounter ++;
            return;
        }
    }


}
