package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameReadView {
    public static final String MESSAGE_DESC_INPUT_NUMBER = "숫자를 입력해주세요 : ";
    public static final String MESSAGE_DESC_INPUT_CONTINUE_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static final String MESSAGE_ERROR_INVALID_INPUT_LENGTH = "입력값은 3자리여야 합니다.";
    public static final String MESSAGE_ERROR_INVALID_INPUT_RANGE = "입력값은 1~9의 숫자여야 합니다.";
    public static final String MESSAGE_ERROR_INVALID_INPUT_DUPLICATED = "입력값은 중복을 허용하지 않습니다.";
    public static final String MESSAGE_ERROR_INVALID_INPUT_FOR_GAME_CONTINUE = "입력값은 1 또는 2여야 합니다.";

    public static final String MESSAGE_VALUE_CONTINUE = "1";
    public static final String MESSAGE_VALUE_EXIT = "2";

    public static List<Integer> readInputNumbers(){
        System.out.print(MESSAGE_DESC_INPUT_NUMBER);
        String input = Console.readLine();
        validateInput(input);

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

    private static boolean checkValidLength(String str) throws IllegalArgumentException{
        if(str.length() != 3){
            throw new IllegalArgumentException(MESSAGE_ERROR_INVALID_INPUT_LENGTH);
        }
        return true;
    }

    private static boolean checkNumbersInValidRange(String str) throws IllegalArgumentException{
        char c1 = str.charAt(0);
        char c2 = str.charAt(1);
        char c3 = str.charAt(2);

        if(c1 < '1' || c1 > '9' || c2 < '1' || c2 > '9' || c3 < '1' || c3 > '9'){
            throw new IllegalArgumentException(MESSAGE_ERROR_INVALID_INPUT_RANGE);
        }
        return true;
    }

    private static boolean checkNumbersAreUnique(String str) throws IllegalArgumentException{
        char c1 = str.charAt(0);
        char c2 = str.charAt(1);
        char c3 = str.charAt(2);

        if(c1 == c2 || c2 == c3 || c1 == c3){
            throw new IllegalArgumentException(MESSAGE_ERROR_INVALID_INPUT_DUPLICATED);
        }
        return true;
    }

    public static boolean readContinueGame() {
        System.out.println(MESSAGE_DESC_INPUT_CONTINUE_GAME);
        String input = Console.readLine();
        if (input.equals(MESSAGE_VALUE_CONTINUE)) {
            return true;
        }
        if (input.equals(MESSAGE_VALUE_EXIT)) {
            return false;
        }
        throw new IllegalArgumentException(MESSAGE_ERROR_INVALID_INPUT_FOR_GAME_CONTINUE);
    }
}
