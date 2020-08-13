package problem;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class P048_SelfPowers implements Problem {

    /*
     * The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.
     *
     * Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.
     */
    public Object getSolution() {
        BigInteger result = IntStream.range(1, 1001)
                .mapToObj(i -> BigInteger.valueOf(i).pow(i))
                .reduce(BigInteger::add)
                .orElseThrow(RuntimeException::new);

        final String resultString = result.toString();
        return resultString.substring(resultString.length() - 10);
    }

//    public Object getSolution() {
//        BigInteger result = BigInteger.ZERO;
//
//        for (int i = 1; i <= 1000; i++) {
//            BigInteger base = new BigInteger(Integer.toString(i));
//
//            result = result.add(base.pow(i));
//        }
//
//        String resultString = result.toString();
//        // System.out.println(resultString);
//
//        int len = resultString.length();
//        return resultString.substring(len - 10);
//    }

}
