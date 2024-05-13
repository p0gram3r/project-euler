package problem;

import org.junit.Test;

import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static problem.P358_CyclicNumbers.CyclicNumber;


public class P358_CyclicNumberTest {

    @Test
    public void notCyclicNumber() {
        CyclicNumber cyclicNumber = CyclicNumber.of("142855");
        assertThat(cyclicNumber.isCyclicNumber(), is(false));
    }

    @Test
    public void smallestCyclicNumberTests() {
        CyclicNumber cyclicNumber = CyclicNumber.of(142857, 6);

        assertThat(cyclicNumber.toString(), is("142857"));
        assertThat(cyclicNumber.length(), is(6));
        assertThat(cyclicNumber.isCyclicNumber(), is(true));
        assertThat(cyclicNumber.sumDigits(), is(1 + 4 + 2 + 8 + 5 + 7));

        Collection<String> rotations = cyclicNumber.possiblerotations();
        assertThat(cyclicNumber.possiblerotations(), hasSize(6));
        assertThat(cyclicNumber.possiblerotations(), hasItem("142857"));
        assertThat(cyclicNumber.possiblerotations(), hasItem("428571"));
    }

    @Test
    public void secondCyclicNumberTests() {
        CyclicNumber cyclicNumber = CyclicNumber.of("0588235294117647");
        assertThat(cyclicNumber.isCyclicNumber(), is(true));
    }
}
