package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class BaseballGameTest {
    @ParameterizedTest(name = "랜덤수 생성 : {0}")
    @ValueSource(ints = {1,3,5})
    void 랜덤_수_생성(int randomNumber){
        Integer[] arr = new Integer[5];
        assertRandomNumberInRangeTest(
                () -> {
                    BaseballGame baseballGame = new BaseballGame();
                    assertThat(baseballGame.getRandomNumbers()).contains(randomNumber);
                },
                1,1, 3, 3, 5, 5, 6, 6
        );
    }

    @ParameterizedTest (name = "볼 테스트 : 랜덤숫자 = 123, 입력값 = {0}, 볼 개수 = {1}")
    @DisplayName("볼 테스트")
    @CsvSource(value = {"451:1", "431:2", "312:3"}, delimiter = ':')
    void 볼_테스트(String input, int ballCounter) {
        assertRandomNumberInRangeTest(
                () -> {
                    BaseballGame baseballGame = new BaseballGame();
                    List<Integer> inputNumbers = stringToIntegerList(input);
                    baseballGame.processInput(inputNumbers);

                    assertThat(baseballGame.getBallCounter()).isEqualTo(ballCounter);
                },
                1, 2, 3
        );
    }

    private List<Integer> stringToIntegerList(String input) {
        List<Integer> result = new ArrayList<>();
        for (char c : input.toCharArray()) {
            result.add(c - '0');
        }
        return result;
    }

    @ParameterizedTest (name = "스크라이크 테스트 : 랜덤숫자 = 123, 입력값 = {0}, 스트라이크 개수 = {1}")
    @DisplayName("스크라이크 테스트")
    @CsvSource(value = {"145:1", "125:2", "123:3"}, delimiter = ':')
    void 스크라이크_테스트(String input, int strikeCounter) {
        assertRandomNumberInRangeTest(
                () -> {
                    BaseballGame baseballGame = new BaseballGame();
                    List<Integer> inputNumbers = stringToIntegerList(input);
                    baseballGame.processInput(inputNumbers);

                    assertThat(baseballGame.getStrikeCounter()).isEqualTo(strikeCounter);
                },
                1, 2,3
        );
    }

    @Test
    @DisplayName("낫싱 테스트")
    void 낫싱_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    BaseballGame baseballGame = new BaseballGame();
                    List<Integer> inputNumbers = Arrays.asList(4,5,6);
                    baseballGame.processInput(inputNumbers);

                    assertThat(baseballGame.getStrikeCounter()).isEqualTo(0);
                    assertThat(baseballGame.getBallCounter()).isEqualTo(0);
                },
                1,2,3
        );
    }

    @Test
    @DisplayName("게임 종료 판단")
    void 게임_종료_판단() {
        assertRandomNumberInRangeTest(
                () -> {
                    BaseballGame baseballGame = new BaseballGame();
                    List<Integer> inputNumbers = Arrays.asList(1, 3, 5);
                    baseballGame.processInput(inputNumbers);

                    assertThat(baseballGame.isGameEnd()).isTrue();
                },
                1, 3, 5
        );
    }
}
