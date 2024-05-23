package problem.p358;

import org.junit.Test;

import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class P358_CyclicNumberTest {

//    @Test
//    public void createNumber() {
//        String number = P358_CyclicNumbers.createNumber(1234L, 5);
//        assertThat(number, is("000000001370123456789"));
//    }

//    @Test
//    public void createInputStream() {
//        var stream = P358_CyclicNumbers.createInputStream(20, 3);
//        var list = stream.toList();
//        assertThat(list, hasSize(20));
//        assertThat(list, hasItem("0000000013700056789"));
//        assertThat(list, hasItem("0000000013701956789"));
//    }

    @Test
    public void increment() {
        assertThat(P358_CyclicNumbers.increment("0"), is("1"));
        assertThat(P358_CyclicNumbers.increment("9"), is("00"));

        assertThat(P358_CyclicNumbers.increment("00"), is("01"));
        assertThat(P358_CyclicNumbers.increment("09"), is("10"));
        assertThat(P358_CyclicNumbers.increment("10"), is("11"));
        assertThat(P358_CyclicNumbers.increment("99"), is("000"));

        assertThat(P358_CyclicNumbers.increment("000"), is("001"));
        assertThat(P358_CyclicNumbers.increment("111"), is("112"));
        assertThat(P358_CyclicNumbers.increment("119"), is("120"));
        assertThat(P358_CyclicNumbers.increment("999"), is("0000"));
    }
}
