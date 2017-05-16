package nl.quintor.kennissessie.pbt.strings;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import nl.quintor.kennissessie.pbt.ReadableCharacter;
import nl.quintor.kennissessie.pbt.ReadableString;
import org.junit.Ignore;
import org.junit.runner.RunWith;

import static nl.quintor.kennissessie.pbt.strings.StringUtils.splitAt;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * A simple but problematic property test for our String splitter.
 */
@RunWith(JUnitQuickcheck.class)
public class StringUtilsPropertyTest1 {

    @Property
    public void splitAt_InverseOfJoin(
            @ReadableCharacter final char c, @ReadableString final String s) {
        assertThat(String.join(Character.toString(c), splitAt(c, s)),
                is(s));
    }

    @Property(trials = 50)
    public void splitAt_SplitsDoNotContainDelimiter(
            @ReadableCharacter final char c, @ReadableString final String s) {
        assertThat(splitAt(c, s),
                everyItem(not(containsString(Character.toString(c)))));
    }
}
