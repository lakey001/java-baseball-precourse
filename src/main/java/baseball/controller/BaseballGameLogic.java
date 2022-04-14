package baseball.controller;

import baseball.domain.BaseballGame;
import baseball.view.GameView;

import java.util.List;

public class BaseballGameLogic {

    public static void start() {
        boolean playGame = true;
        while(playGame) {
            BaseballGame baseballGame = new BaseballGame();
            playGame(baseballGame);
            playGame = GameView.readContinueGame();
        }
    }

    private static void playGame(BaseballGame baseballGame) {
        while(!baseballGame.isGameEnd()) {
            List<Integer> inputNumbers = GameView.readInputNumbers();
            baseballGame.proceed(inputNumbers);
            GameView.printResult(baseballGame);
        }
        GameView.printGameEnd();
    }
}
