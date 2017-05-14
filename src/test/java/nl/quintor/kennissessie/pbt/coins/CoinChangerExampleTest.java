package nl.quintor.kennissessie.pbt.coins;

import java.util.Arrays;

import static nl.quintor.kennissessie.pbt.coins.Coin.*;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

public class CoinChangerExampleTest {
    private CoinChanger coinChanger = new CoinChanger();

    public void minimalChange_simple() {
        assertThat(coinChanger.minimalChange(200),
                is(Arrays.asList($2_00)));
    }

    public void minimalChange_complex() {
        assertThat(coinChanger.minimalChange(387),
                containsInAnyOrder($2_00, $1_00, $0_50, $0_20, $0_10, $0_05, $0_01, $0_01));
    }

    public void minimalChange_zero() {
        assertThat(coinChanger.minimalChange(0),
                is(empty()));
    }
}