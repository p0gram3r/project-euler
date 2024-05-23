package problem.p358;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableSet;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

class CyclicNumber {

    private final String number;
    private final int length;
    private final Set<String> rotations = new HashSet<>();

    private CyclicNumber(String number) {
        this.number = number;
        this.length = number.length();

        rotations.add(number);
        for (int i = 1; i < number.length(); i++) {
            var rotation = number.substring(i, length) + number.substring(0, i);
            rotations.add(rotation);
        }
    }

    public static CyclicNumber of(String number) {
        return new CyclicNumber(number);
    }

    int length() {
        return length;
    }

    Collection<String> possibleRotations() {
        return ImmutableSet.copyOf(rotations);
    }

    @Override
    public String toString() {
        return number;
    }

    boolean isCyclicNumber() {
        return IntStream.rangeClosed(1, length)
                .parallel()
                .mapToObj(this::multiply)
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

    String multiply(int factor) {
        var digits = Splitter.fixedLength(1)
                .splitToStream(number)
                .mapToInt(Integer::parseInt)
                .toArray();

        int transfer = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = digits[i] * factor + transfer;
            if (digits[i] > 9) {
                var temp = digits[i] % 10;
                transfer = digits[i] / 10;
                digits[i] = temp;
            } else {
                transfer = 0;
            }
        }

        if (transfer > 0) {
            digits[0] = transfer * 10 + digits[0];
        }

        return Arrays.stream(digits)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(""));
    }
}
