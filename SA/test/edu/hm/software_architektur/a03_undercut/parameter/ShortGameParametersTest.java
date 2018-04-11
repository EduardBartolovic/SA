
package edu.hm.software_architektur.a03_undercut.parameter;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 *
 * @author Edo
 */
public class ShortGameParametersTest {
    
    public ShortGameParametersTest() {
    }

    @Test
    public void testGetScoreToWin() {
        final Parameters sut = new ShortGameParameters();
        assertThat(sut.getScoreToWin(), is(12));
    }

    @Test
    public void testGetChooseRange() {
        final Parameters sut = new ShortGameParameters();
        assertThat(sut.getChooseRange(), is(new int[]{1,3}));
    }
    
}
