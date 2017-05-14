package nl.quintor.kennissessie.pbt.lists;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ListUtilsExampleTest1 {
    /*
     * reverse
     */
    @Test
    public void reverse() {
        assertThat(ListUtils.reverse(Arrays.asList(1, 2, 3)),
                is(Arrays.asList(3, 2, 1)));
    }

    @Test
    public void reverseEmpty() {
        assertThat(ListUtils.reverse(Arrays.asList()),
                is(Arrays.asList()));
    }

    @Test
    public void reverseSingle() {
        assertThat(ListUtils.reverse(Arrays.asList(1)),
                is(Arrays.asList(1)));
    }

    /*
     * concat
     */
    @Test
    public void concat() {
        assertThat(ListUtils.concat(Arrays.asList(1, 2), Arrays.asList(3)),
                is(Arrays.asList(1, 2, 3)));
    }

    @Test
    public void concatEmptyL() {
        assertThat(ListUtils.concat(Arrays.asList(), Arrays.asList(1, 2, 3)),
                is(Arrays.asList(1, 2, 3)));
    }

    @Test
    public void concatEmptyR() {
        assertThat(ListUtils.concat(Arrays.asList(1, 2, 3), Arrays.asList()),
                is(Arrays.asList(1, 2, 3)));
    }

    @Test
    public void concatEmptyBoth() {
        assertThat(ListUtils.concat(Arrays.asList(), Arrays.asList()),
                is(Arrays.asList()));
    }

    /*
     * sort
     */
    @Test
    public void sort() {
        assertThat(ListUtils.sort(Arrays.asList(3, 2, 1)),
                is(Arrays.asList(1, 2, 3)));
    }

    @Test
    public void sortEmpty() {
        assertThat(ListUtils.<Integer>sort(Arrays.asList()),
                is(Arrays.asList()));
    }

    /*
     * first
     */
    @Test
    public void first() {
        assertThat(ListUtils.first(Arrays.asList(1, 2, 3)),
                is(1));
    }

    /*
     * last
     */
    @Test
    public void last() {
        assertThat(ListUtils.last(Arrays.asList(1, 2, 3)),
                is(3));
    }

    /*
     * smallest
     */
    @Test
    public void smallest() {
        assertThat(ListUtils.smallest(Arrays.asList(1, 2, 3)),
                is(1));
    }

    /*
     * greatest
     */
    @Test
    public void greatest() {
        assertThat(ListUtils.greatest(Arrays.asList(1, 2, 3)),
                is(3));
    }
}