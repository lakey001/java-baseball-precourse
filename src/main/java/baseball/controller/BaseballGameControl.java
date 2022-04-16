package baseball.controller;

import baseball.domain.BaseballGame;
import baseball.view.GamePrintView;
import baseball.view.GameReadView;

import java.util.List;

public class BaseballGameControl {
    public static void start() {
        boolean playGame = true;
        while(playGame) {
            playNewGame();
            playGame = GameReadView.readContinueGame();
        }
    }

    private static void playNewGame() {
        BaseballGame baseballGame = new BaseballGame();
        while(!baseballGame.isGameEnd()) {
            List<Integer> inputNumbers = GameReadView.readInputNumbers();
            baseballGame.processInput(inputNumbers);
            GamePrintView.printProcessResult(baseballGame);
        }
        GamePrintView.printGameEnd();
    }
}
