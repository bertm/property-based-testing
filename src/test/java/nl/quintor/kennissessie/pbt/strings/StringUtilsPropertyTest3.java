package nl.quintor.kennissessie.pbt.strings;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import nl.quintor.kennissessie.pbt.ReadableString;
import org.junit.Ignore;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static nl.quintor.kennissessie.pbt.strings.StringUtils.splitAt;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * A better property test for our String splitter.
 */
@Ignore
@RunWith(JUnitQuickcheck.class)
public class StringUtilsPropertyTest3 {

    @Property
    public void splitAt_InverseOfJoin_ForAllPresentDelimiters(@ReadableString final String toSplit) {
        for (int i = 0; i < toSplit.length(); i++) {
            final char delimiter = toSplit.charAt(i);
            assertThat(String.join(Character.toString(delimiter), splitAt(delimiter, toSplit)),
                    is(toSplit));
        }
    }

    @Property
    public void splitAt_Singleton_ForMissingDelimiter(@ReadableString final String toSplit) {
        for (int i = 0; i < toSplit.length(); i++) {
            final char delimiter = toSplit.charAt(i);
            final String withoutDelimiter = toSplit.replace(Character.toString(delimiter), "");
            assertThat(splitAt(delimiter, withoutDelimiter),
                    is(Arrays.asList(toSplit)));
        }
    }

    @Property
    public void splitAt_SplitsDoNotContainDelimiter(@ReadableString final String toSplit) {
        for (int i = 0; i < toSplit.length(); i++) {
            final char delimiter = toSplit.charAt(i);
            assertThat(splitAt(delimiter, toSplit),
                    everyItem(not(containsString(Character.toString(delimiter)))));
        }
    }
}
