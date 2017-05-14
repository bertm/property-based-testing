package nl.quintor.kennissessie.pbt.strings;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StringUtilsExampleTest {
    @Test
    public void testSplit() {
        assertThat(StringUtils.splitAt('@', "b.massop@quintor.nl"),
                is(Arrays.asList("b.massop", "quintor.nl")));
    }

    @Test
    public void testSplitEmpty() {
        assertThat(StringUtils.splitAt('x', ""),
                is(Arrays.asList("")));
    }
}