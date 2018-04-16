
package edu.hm.software_architektur.a03_undercut.parameter;

import edu.hm.peither_bartolov.a03_undercut.parameter.ShortGameParameters;
import edu.hm.peither_bartolov.a03_undercut.parameter.Parameters;
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
        assertThat(sut.getChooseRange().toArray(), is(new int[]{1,2,3}));
    }
    
}
