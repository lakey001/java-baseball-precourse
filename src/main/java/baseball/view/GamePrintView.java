package baseball.view;

import baseball.domain.BaseballGame;

public class GamePrintView {
    public static final String MESSAGE_DESC_GAME_END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String MESSAGE_BALL = "볼";
    public static final String MESSAGE_STRIKE = "스트라이크";
    public static final String MESSAGE_NOTHING = "낫싱";

    public static void printProcessResult(BaseballGame baseballGame) {
        if(baseballGame.getBallCounter() > 0) {
            System.out.print(baseballGame.getBallCounter() + MESSAGE_BALL + " ");
        }
        if(baseballGame.getStrikeCounter() > 0){
            System.out.print(baseballGame.getStrikeCounter() + MESSAGE_STRIKE);
        }
        if(baseballGame.getBallCounter() == 0 && baseballGame.getStrikeCounter() == 0){
            System.out.print(MESSAGE_NOTHING);
        }
        System.out.print("\n");
    }

    public static void printGameEnd() {
        System.out.println(MESSAGE_DESC_GAME_END);
    }
}
