package nl.quintor.kennissessie.pbt;

import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.generator.java.lang.AbstractStringGenerator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

public class InRangeStringGenerator extends AbstractStringGenerator {

    private char min;
    private char max;

    public void configure(InRange range) {
        this.min = range.min().isEmpty() ? range.minChar() : range.min().charAt(0);
        this.max = range.max().isEmpty() ? range.maxChar() : range.max().charAt(0);
    }

    @Override
    protected int nextCodePoint(SourceOfRandomness random) {
        return random.nextChar(min, max);
    }

    @Override
    protected boolean codePointInRange(int i) {
        return i >= min && i <= max;
    }
}