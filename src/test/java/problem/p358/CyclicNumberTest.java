package problem.p358;

import org.junit.Test;

import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CyclicNumberTest {

    @Test
    public void notCyclicNumber() {
        CyclicNumber cyclicNumber = CyclicNumber.of("142855");
        assertThat(cyclicNumber.isCyclicNumber(), is(false));
    }

    @Test
    public void smallestCyclicNumberTests() {
        CyclicNumber cyclicNumber = CyclicNumber.of("142857");

        assertThat(cyclicNumber.toString(), is("142857"));
        assertThat(cyclicNumber.length(), is(6));
        assertThat(cyclicNumber.isCyclicNumber(), is(true));
        assertThat(cyclicNumber.sumDigits(), is(1 + 4 + 2 + 8 + 5 + 7));

        Collection<String> rotations = cyclicNumber.possibleRotations();
        assertThat(rotations, hasSize(6));
        assertThat(rotations, containsInAnyOrder("142857", "428571", "285714", "857142", "571428", "714285"));
    }

    @Test
    public void secondCyclicNumberTests() {
        CyclicNumber cyclicNumber = CyclicNumber.of("0588235294117647");
        assertThat(cyclicNumber.isCyclicNumber(), is(true));
    }

    @Test
    public void zeroIsNotACyclicNumber() {
        // TODO this fails
        CyclicNumber cyclicNumber = CyclicNumber.of("0");
        assertThat(cyclicNumber.isCyclicNumber(), is(false));
    }

    @Test
    public void multiplySmallestCyclicNumber() {
        CyclicNumber cyclicNumber = CyclicNumber.of("0588235294117647");
        assertThat(cyclicNumber.multiply(1), is("0588235294117647"));
        assertThat(cyclicNumber.multiply(5), is("2941176470588235"));
    }

    @Test
    public void multiplySecondSmallestCyclicNumber() {
        CyclicNumber cyclicNumber = CyclicNumber.of("142857");
        assertThat(cyclicNumber.multiply(1), is("142857"));
        assertThat(cyclicNumber.multiply(2), is("285714"));
        assertThat(cyclicNumber.multiply(3), is("428571"));
        assertThat(cyclicNumber.multiply(4), is("571428"));
        assertThat(cyclicNumber.multiply(5), is("714285"));
        assertThat(cyclicNumber.multiply(6), is("857142"));
    }

    @Test
    public void multiply() {
        CyclicNumber cyclicNumber = CyclicNumber.of("1");
        assertThat(cyclicNumber.multiply(1), is("1"));
        assertThat(cyclicNumber.multiply(2), is("2"));
        assertThat(cyclicNumber.multiply(4), is("4"));

        cyclicNumber = CyclicNumber.of("001");
        assertThat(cyclicNumber.multiply(1), is("001"));
        assertThat(cyclicNumber.multiply(2), is("002"));
        assertThat(cyclicNumber.multiply(4), is("004"));

        cyclicNumber = CyclicNumber.of("012345");
        assertThat(cyclicNumber.multiply(1), is("012345"));
        assertThat(cyclicNumber.multiply(2), is("024690"));

        cyclicNumber = CyclicNumber.of("540450");
        assertThat(cyclicNumber.multiply(3), is("1621350"));
    }
}
