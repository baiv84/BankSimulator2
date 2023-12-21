package tools;

import java.util.PrimitiveIterator;
import java.util.Random;

public final class LongRandomNumberGenerator {

    private PrimitiveIterator.OfLong randomIterator;

    /**
     * Initialize a new random number generator that generates
     * random numbers in the range [min, max]
     * @param min - the min value (inclusive)
     * @param max - the max value (inclusive)
     */
    public LongRandomNumberGenerator(long min, long max) {
        randomIterator = new Random().longs(min, max + 1).iterator();
    }

    /**
     * Returns a random number in the range (min, max)
     * @return a random number in the range (min, max)
     */
    public long nextLong() {
        return randomIterator.nextLong();
    }
}