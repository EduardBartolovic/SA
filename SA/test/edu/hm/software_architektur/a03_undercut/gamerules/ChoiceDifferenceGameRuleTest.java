package edu.hm.software_architektur.a03_undercut.gamerules;

import edu.hm.bartolov.a03_undercut.gamerules.GameRule;
import edu.hm.bartolov.a03_undercut.gamerules.ChoiceDifferenceGameRule;
import java.util.Arrays;
import java.util.Collection;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author Edo
 */
@RunWith(value = Parameterized.class)
public class ChoiceDifferenceGameRuleTest {
    
    
    private final int a ;
    private final int b;
    private final int[] expected;

    // Inject via constructor
    // for {8, 2, 10}, numberA = 8, numberB = 2, expected = 10
    public ChoiceDifferenceGameRuleTest(int[] choices,int[] expected) {
        this.a = choices[0];
        this.b = choices[1];
        this.expected = expected;
    }

	// name attribute is optional, provide an unique name for test
	// multiple parameters, uses Collection<Object[]>
    @Parameterized.Parameters(name = "{index}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {new int[]{1,1},new int[]{1,1}},
            {new int[]{5,5},new int[]{5,5}},
            {new int[]{3,3},new int[]{3,3}},
            {new int[]{2,2},new int[]{2,2}},
            {new int[]{99,99},new int[]{99,99}},
            {new int[]{4,5},new int[]{9,0}},
            {new int[]{5,4},new int[]{0,9}},
            {new int[]{1,4},new int[]{0,5}}, //test 7
            {new int[]{2,4},new int[]{0,6}},
            {new int[]{4,2},new int[]{6,0}},
            {new int[]{4,3},new int[]{0,7}},
            {new int[]{4,1},new int[]{5,0}},
            
        });
    }
    
    @Test(timeout=2000)
    public void test_DefaultVerify() {
        final GameRule sut = new ChoiceDifferenceGameRule();
        assertThat(sut.calculateScore(a, b), is(expected)); 
    }
    
}
