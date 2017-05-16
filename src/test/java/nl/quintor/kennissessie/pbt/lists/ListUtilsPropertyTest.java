package nl.quintor.kennissessie.pbt.lists;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import nl.quintor.kennissessie.pbt.Small;
import org.junit.Ignore;
import org.junit.runner.RunWith;

import java.util.List;

import static nl.quintor.kennissessie.pbt.lists.ListUtils.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assume.assumeThat;

@RunWith(JUnitQuickcheck.class)
public class ListUtilsPropertyTest {

    /**
     * Sorting is idempotent: applying sort() multiple times does not change the result.
     */
    @Property
    public void sort_Idempotent(final List<@Small Integer> list) {
        assertThat(sort(list),
                is(sort(sort(list))));
    }

    /**
     * Sorting preserves the size of the list.
     */
    @Property
    public void sort_Size(final List<@Small Integer> list) {
        assertThat(sort(list),
                hasSize(list.size()));
    }

    /**
     * Sorting a list is the same as sorting its inverse.
     */
    @Property
    public void sort_reverse(final List<@Small Integer> list) {
        assertThat(sort(list),
                is(sort(reverse(list))));
    }

    /**
     * Reversal places the first element at the end of the non-empty list.
     */
    @Property
    public void reverse_FirstLast(final List<@Small Integer> list) {
        assumeThat(list, not(empty()));
        assertThat(last(reverse(list)),
                is(first(list)));
    }

    /**
     * Reversal places the last element at the begin of the non-empty list.
     */
    @Property
    public void reverse_LastFirst(final List<@Small Integer> list) {
        assumeThat(list, not(empty()));
        assertThat(first(reverse(list)),
                is(last(list)));
    }

    /**
     * Reversal preserves the size of a list.
     */
    @Property
    public void reverse_Size(final List<@Small Integer> list) {
        assertThat(reverse(list),
                hasSize(list.size()));
    }

    /**
     * Reversal is its own reverse: applying reverse twice leads to the original list.
     */
    @Property
    public void reverse_Inverse(final List<@Small Integer> list) {
        assertThat(reverse(reverse(list)),
                is(list));
    }

    /**
     * Concatenation leads to a list of size equal to the sum of the originals.
     */
    @Property
    public void concat_Size(
            final List<@Small Integer> left, final List<@Small Integer> right) {
        assertThat(concat(left, right),
                hasSize(left.size() + right.size()));
    }

    /**
     * The concatenation of two lists starts with the first list.
     */
    @Property
    public void concat_BeginsWithLeft(
            final List<@Small Integer> left, final List<@Small Integer> right) {
        assertThat(concat(left, right).subList(0, left.size()),
                is(left));
    }

    /**
     * The concatenation of two lists ends with the last list.
     */
    @Property
    public void concat_EndsWithRight(
            final List<@Small Integer> left, final List<@Small Integer> right) {
        assertThat(concat(left, right).subList(left.size(), left.size() + right.size()),
                is(right));
    }

    /**
     * Reverse distributes over concat
     * <p>
     * reverse(concat(left, right)) == concat(reverse(right), revserse(left))
     */
    @Property
    public void concat_reverse(
            final List<@Small Integer> left, final List<@Small Integer> right) {
        assertThat(reverse(concat(left, right)),
                is(concat(reverse(right), reverse(left))));
    }

    /**
     * The first element of a sorted list is the smallest element.
     */
    @Property
    public void smallest_FirstSorted(final List<@Small Integer> list) {
        assumeThat(list, not(empty()));
        assertThat(first(sort(list)),
                comparesEqualTo(smallest(list)));
    }

    /**
     * The last element of a sorted list is the greatest element.
     */
    @Property
    public void greatest_LastSorted(final List<@Small Integer> list) {
        assumeThat(list, not(empty()));
        assertThat(last(sort(list)),
                comparesEqualTo(greatest(list)));
    }
}