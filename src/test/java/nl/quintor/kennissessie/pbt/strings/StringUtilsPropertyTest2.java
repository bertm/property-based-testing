package nl.quintor.kennissessie.pbt.strings;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import nl.quintor.kennissessie.pbt.ReadableCharacter;
import nl.quintor.kennissessie.pbt.ReadableString;
import org.junit.Ignore;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static nl.quintor.kennissessie.pbt.strings.StringUtils.splitAt;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assume.assumeThat;

/**
 * A slightly less problematic property test for our String splitter.
 */
@RunWith(JUnitQuickcheck.class)
public class StringUtilsPropertyTest2 {

    @Property
    public void splitAt_InverseOfJoin_WithDelimiter(
            @ReadableCharacter final char delimiter, @ReadableString final String toSplit) {
        assumeThat(toSplit, containsString(Character.toString(delimiter)));
        assertThat(String.join(Character.toString(delimiter), splitAt(delimiter, toSplit)),
                is(toSplit));
    }

    @Property
    public void splitAt_Singleton_WithoutDelimiter(
            @ReadableCharacter final char delimiter, @ReadableString final String toSplit) {
        assumeThat(toSplit, not(containsString(Character.toString(delimiter))));
        final String withoutDelimiter = toSplit.replace(Character.toString(delimiter), "");
        assertThat(splitAt(delimiter, withoutDelimiter),
                is(Arrays.asList(withoutDelimiter)));
    }

    @Property
    public void splitAt_SplitsDoNotContainDelimiter(
            @ReadableCharacter final char delimiter, @ReadableString final String toSplit) {
        assumeThat(toSplit, containsString(Character.toString(delimiter)));
        assertThat(splitAt(delimiter, toSplit),
                everyItem(not(containsString(Character.toString(delimiter)))));
    }
}
