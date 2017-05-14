package nl.quintor.kennissessie.pbt;

import com.pholser.junit.quickcheck.generator.InRange;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({PARAMETER, FIELD, ANNOTATION_TYPE, TYPE_USE})
@Retention(RUNTIME)
@InRange(
        minInt = -10, maxInt = 10,
        minChar = 0x20, maxChar = 0x7E,
        minDouble = -1.0d, maxDouble = 1.0d,
        minFloat = -1.0f, maxFloat = 1.0f
)
public @interface Small {
}