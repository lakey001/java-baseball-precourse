package baseball.view;

import baseball.domain.BaseballGame;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GamePrintView {
    public static void printProcessResult(BaseballGame baseballGame) {
        if(baseballGame.getBallCounter() > 0) {
            System.out.print(baseballGame.getBallCounter() + "볼 ");
        }
        if(baseballGame.getStrikeCounter() > 0){
            System.out.print(baseballGame.getStrikeCounter() + "스트라이크");
        }
        if(baseballGame.getBallCounter() == 0 && baseballGame.getStrikeCounter() == 0){
            System.out.print("낫싱");
        }
        System.out.print("\n");
    }

    public static void printGameEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
