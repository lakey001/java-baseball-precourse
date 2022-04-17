package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class BaseballGameTest {
    @ParameterizedTest(name = "랜덤수 생성 : {0}")
    @ValueSource(ints = {1,3,5})
    void 랜덤_수_생성(int randomNumber){
        assertRandomNumberInRangeTest(
                () -> {
                    BaseballGame baseballGame = new BaseballGame();
                    assertThat(baseballGame.getRandomNumbers()).contains(randomNumber);
                },
                1,1, 3, 3, 5, 5, 6, 6
        );
    }

    @Test
    @DisplayName("볼 테스트")
    void 볼_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    BaseballGame baseballGame = new BaseballGame();
                    List<Integer> inputNumbers = Arrays.asList(5, 1, 3);
                    baseballGame.processInput(inputNumbers);

                    assertThat(baseballGame.getBallCounter()).isEqualTo(3);
                },
                1, 3, 5
        );
    }

    @Test
    @DisplayName("스트라이크 테스트")
    void 스크라이크_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    BaseballGame baseballGame = new BaseballGame();
                    List<Integer> inputNumbers = Arrays.asList(1, 3, 6);
                    baseballGame.processInput(inputNumbers);

                    assertThat(baseballGame.getStrikeCounter()).isEqualTo(2);
                },
                1, 3, 5
        );
    }

    @Test
    @DisplayName("낫싱 테스트")
    void 낫싱_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    BaseballGame baseballGame = new BaseballGame();
                    List<Integer> inputNumbers = Arrays.asList(7, 8, 9);
                    baseballGame.processInput(inputNumbers);

                    assertThat(baseballGame.getStrikeCounter()).isEqualTo(0);
                    assertThat(baseballGame.getBallCounter()).isEqualTo(0);
                },
                1, 3, 5
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
