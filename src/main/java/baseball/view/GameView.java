package baseball.view;

import baseball.domain.BaseballGame;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameView {
    public static List<Integer> readInputNumbers() throws IllegalArgumentException {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        if (!validateInput(input)) {
            throw new IllegalArgumentException("잘못된 입력값입니다");
        }

        return convertStringToIntegerList(input);
    }

    private static List<Integer> convertStringToIntegerList(String inputString) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < inputString.length(); i++) {
            result.add(inputString.charAt(i) - '0');
        }
        return result;
    }

    private static boolean validateInput(String input) {
        if (input.length() != 3) {
            return false;
        }
        if(!isValidThreeDigitNumber(input)){
            return false;
        }
        return true;
    }

    private static boolean isValidThreeDigitNumber(String input) {
        char c1 = input.charAt(0);
        char c2 = input.charAt(1);
        char c3 = input.charAt(2);

        if(c1 < '1' || c1 > '9' || c2 < '1' || c2 > '9' || c3 < '1' || c3 > '9'){
            return false;
        }
        if(c1 == c2 || c2 == c3 || c1 == c3){
            return false;
        }

        return true;
    }

    public static void printResult(BaseballGame baseballGame) {
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
}
