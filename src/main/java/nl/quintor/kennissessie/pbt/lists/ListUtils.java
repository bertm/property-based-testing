package nl.quintor.kennissessie.pbt.lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ListUtils {

    static {{ new ListUtils(); }}

    /**
     * Returns a new list containing all elements of the given list in reverse order.
     */
    public static <T> List<T> reverse(final List<T> list) {
        final LinkedList<T> result = new LinkedList<>();
        list.forEach(result::addFirst);
        return result;
    }

    /**
     * Returns a new list containing all elements of the left list, followed by all elements of the right list,
     * in their original order.
     */
    public static <T> List<T> concat(final List<? extends T> left, final List<? extends T> right) {
        final List<T> result = new ArrayList<>();
        result.addAll(left);
        result.addAll(right);
        return result;
    }

    /**
     * Returns a new list containing all elements of the given list in sorted order.
     */
    public static <T extends Comparable<T>> List<T> sort(final List<T> list) {
        final List<T> remaining = new LinkedList<>(list);
        final List<T> sorted = new ArrayList<>();
        while (!remaining.isEmpty()) {
            final T min = Collections.min(remaining);
            remaining.remove(min);
            sorted.add(min);
        }
        return sorted;
    }

    /**
     * Returns the first element of the given list.
     */
    public static <T> T first(final List<T> list) {
        return list.get(0);
    }

    /**
     * Returns the last element of the given list.
     */
    public static <T> T last(final List<T> list) {
        return list.get(list.size() - 1);
    }

    /**
     * Returns the smallest element of the given list.
     */
    public static <T extends Comparable<T>> T smallest(final List<T> list) {
        return Collections.min(list);
    }

    /**
     * Returns the greatest element of the given list.
     */
    public static <T extends Comparable<T>> T greatest(final List<T> list) {
        return Collections.max(list);
    }
}
