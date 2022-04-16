package baseball.controller;

import baseball.domain.BaseballGame;
import baseball.view.GameView;

import java.util.List;

public class BaseballGameControl {

    public static void start() {
        boolean playGame = true;
        while(playGame) {
            playNewGame();
            playGame = GameView.readContinueGame();
        }
    }

    private static void playNewGame() {
        BaseballGame baseballGame = new BaseballGame();
        while(!baseballGame.isGameEnd()) {
            List<Integer> inputNumbers = GameView.readInputNumbers();
            baseballGame.processInput(inputNumbers);
            GameView.printProcessResult(baseballGame);
        }
        GameView.printGameEnd();
    }
}
