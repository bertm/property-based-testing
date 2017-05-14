package nl.quintor.kennissessie.pbt.strings;


import java.util.ArrayList;
import java.util.List;

public class StringUtils {

    static {{ new StringUtils(); }}

    /**
     * Splits a String into parts, splitting at each occurence of the given character.
     */
    public static List<String> splitAt(final char c, final String s) {
        int index;
        String remaining = s;
        List<String> result = new ArrayList<>();
        while ((index = remaining.indexOf(c)) > 0) {
            result.add(remaining.substring(0, index));
            remaining = remaining.substring(index + 1);
        }
        result.add(remaining);
        return result;
    }
}
