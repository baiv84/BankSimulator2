package tools;

import java.util.PrimitiveIterator;
import java.util.Random;

public final class LongRandomNumberGenerator {

    private PrimitiveIterator.OfLong randomIterator;

    public LongRandomNumberGenerator(long min, long max) {
        randomIterator = new Random().longs(min, max + 1).iterator();
    }

    public long nextLong() {
        return randomIterator.nextLong();
    }
}