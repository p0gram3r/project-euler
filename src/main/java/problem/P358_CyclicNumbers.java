package problem;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableSet;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class P358_CyclicNumbers implements Problem {
    @Override
    public Object getSolution() {
        return null;
    }


    protected static class CyclicNumber {

        private final String number;
        private final int length;
        private final Set<String> rotations = new HashSet<>();

        private CyclicNumber(String number) {
            this.number = number;
            this.length = number.length();

            rotations.add(number);
            for (int i = 1; i < number.length(); i++) {
                String rotation = number.substring(i,length) + number.substring(0,i);
                rotations.add(rotation);
            }
        }

        public static CyclicNumber of(long number, int len) {
            var s = Strings.padStart(Long.toString(number), len, '0');
            return new CyclicNumber(s);

        }

        public static CyclicNumber of(String number) {
            return new CyclicNumber(number);
        }

        int length() {
            return length;
        }

        Collection<String> possiblerotations() {
            return ImmutableSet.copyOf(rotations);
        }

        @Override
        public String toString() {
            return number;
        }

        boolean isCyclicNumber() {
            // TODO nope! we have to retain leading zeros and deal with them properly during multiplication.
            // Otherwise the result of multiplying by 1 will not be in the list of rotations.
            long actualNumber = Long.parseLong(CharMatcher.is('0').trimLeadingFrom(number));

            return LongStream.rangeClosed(1, length())
                    .parallel()
                    .map(i -> i * actualNumber)
                    .mapToObj(String::valueOf)
                    .filter(product -> !rotations.contains(product))
                    .findAny()
                    .isEmpty();
        }

        int sumDigits() {
            return Splitter.fixedLength(1)
                    .splitToStream(number)
                    .mapToInt(Integer::parseInt)
                    .sum();
        }

    }
}
