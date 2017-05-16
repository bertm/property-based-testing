package nl.quintor.kennissessie.pbt.lists;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ListUtilsExampleTest2 {

    @Test
    public void sortSorted() {
        assertThat(ListUtils.sort(Arrays.asList(1, 2, 3)),
                is(Arrays.asList(1, 2, 3)));
    }
}
