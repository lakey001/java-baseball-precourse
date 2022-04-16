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
        if(checkValidLength(input)
            && checkNumbersInValidRange(input)
            && checkNumbersAreUnique(input)) {
            return true;
        }
        return false;
    }

    private static boolean checkValidLength(String str) {
        if(str.length() != 3){
            return false;
        }
        return true;
    }

    private static boolean checkNumbersInValidRange(String str) {
        char c1 = str.charAt(0);
        char c2 = str.charAt(1);
        char c3 = str.charAt(2);

        if(c1 < '1' || c1 > '9' || c2 < '1' || c2 > '9' || c3 < '1' || c3 > '9'){
            return false;
        }
        return true;
    }

    private static boolean checkNumbersAreUnique(String str) {
        char c1 = str.charAt(0);
        char c2 = str.charAt(1);
        char c3 = str.charAt(2);

        if(c1 == c2 || c2 == c3 || c1 == c3){
            return false;
        }
        return true;
    }

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

    public static boolean readContinueGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (input.equals("1")) {
            return true;
        }
        if (input.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException();
    }
}
