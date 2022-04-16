package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private List<Integer> randomNumbers;
    private boolean gameEnd;
    private int strikeCounter;
    private int ballCounter;

    public BaseballGame() {
        this.randomNumbers = generateRandomNumbers();
        this.gameEnd = false;
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            randomNumbers.add(generateUniqueRandomNumber(randomNumbers));
        }
        return randomNumbers;
    }

    private int generateUniqueRandomNumber(List<Integer> randomNumbers) {
        int random = Randoms.pickNumberInRange(1, 9);
        while (randomNumbers.contains(random)) {
            random = Randoms.pickNumberInRange(1, 9);
        }
        return random;
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

    public void processInput(List<Integer> inputNumbers) {
        strikeCounter = 0;
        ballCounter = 0;
        for(int i = 0; i < 3; i++){
            updateGuessCounter(inputNumbers.get(i), i);
        }
        if(strikeCounter == 3){
            gameEnd = true;
        }
    }

    private void updateGuessCounter(Integer number, int idx) {
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
