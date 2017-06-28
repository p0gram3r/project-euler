package problem;

import java.math.BigInteger;

public class P048_SelfPowers implements Problem {

    public Object getSolution() {
        BigInteger result = BigInteger.ZERO;

        for (int i = 1; i <= 1000; i++) {
            BigInteger base = new BigInteger(Integer.toString(i));

            result = result.add(base.pow(i));
        }

        String resultString = result.toString();
        // System.out.println(resultString);

        int len = resultString.length();
        return resultString.substring(len - 10);
    }

}
