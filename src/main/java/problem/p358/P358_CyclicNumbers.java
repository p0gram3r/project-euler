package problem.p358;

import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import problem.Problem;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P358_CyclicNumbers implements Problem {
    @Override
    public Object getSolution() {
        int maxLength = 6;

        var cyclicNumber = createNumberStream(maxLength)
                .map(CyclicNumber::of)
                .filter(CyclicNumber::isCyclicNumber)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("maxLength not sufficient"));

        System.out.println(cyclicNumber);
        return cyclicNumber.sumDigits();
    }


    protected static Stream<String> createNumberStream(int maxLength) {
        var limit = BigInteger.valueOf(11L).pow(maxLength + 1).longValue();

        return Stream.iterate("0", P358_CyclicNumbers::increment)
                // TODO add known prefix and suffix
                .limit(limit);
    }

    protected static String increment(String input) {
        var digits = input.toCharArray();

        boolean overflow = false;
        int i = digits.length;
        do {
            i = i - 1;
            digits[i] += 1;
            if (digits[i] == ':') {
                digits[i] = '0';
                overflow = true;
            } else {
                overflow = false;
            }
        }
        while (i != 0 && overflow);

        var result = new String(digits);
        return overflow ? "0" + result : result;
    }

}
