
package edu.hm.software_architektur.a03_undercut.parameter;

import edu.hm.bartolov.a03_undercut.parameter.InstableParameters;
import edu.hm.bartolov.a03_undercut.parameter.Parameters;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 *
 * @author Edo
 */
public class InstableParametersTest {
    
    public InstableParametersTest() {
    }

    @Test
    public void testGetScoreToWin() {
        final Parameters sut = new InstableParameters();
        assertThat(sut.getScoreToWin(), is(42));
    }

    @Test
    public void testGetChooseRange1() {
        final Parameters sut = new InstableParameters();
        assertThat(sut.getChooseRange().toArray(), is(new int[]{1,2,3,4})); //a
        assertThat(sut.getChooseRange().toArray(), is(new int[]{2,3,4,5})); //b
        
        assertThat(sut.getChooseRange().toArray(), is(new int[]{2,3,4,5})); //a
        assertThat(sut.getChooseRange().toArray(), is(new int[]{1,3,5}));   //b
        
        assertThat(sut.getChooseRange().toArray(), is(new int[]{1,3,5})); //a
        assertThat(sut.getChooseRange().toArray(), is(new int[]{1,2,3,4}));   //b
        
        assertThat(sut.getChooseRange().toArray(), is(new int[]{1,2,3,4})); //a
        assertThat(sut.getChooseRange().toArray(), is(new int[]{2,3,4,5})); //b
        
        assertThat(sut.getChooseRange().toArray(), is(new int[]{2,3,4,5})); //a
        assertThat(sut.getChooseRange().toArray(), is(new int[]{1,3,5}));   //b
        
        assertThat(sut.getChooseRange().toArray(), is(new int[]{1,3,5})); //a
        assertThat(sut.getChooseRange().toArray(), is(new int[]{1,2,3,4}));   //b
        
        assertThat(sut.getChooseRange().toArray(), is(new int[]{1,2,3,4})); //a
        assertThat(sut.getChooseRange().toArray(), is(new int[]{2,3,4,5})); //b
        
        assertThat(sut.getChooseRange().toArray(), is(new int[]{2,3,4,5})); //a
        assertThat(sut.getChooseRange().toArray(), is(new int[]{1,3,5}));   //b
        
        assertThat(sut.getChooseRange().toArray(), is(new int[]{1,3,5})); //a
        assertThat(sut.getChooseRange().toArray(), is(new int[]{1,2,3,4}));   //b
        
        assertThat(sut.getChooseRange().toArray(), is(new int[]{1,2,3,4})); //a
        assertThat(sut.getChooseRange().toArray(), is(new int[]{2,3,4,5})); //b
        
        assertThat(sut.getChooseRange().toArray(), is(new int[]{2,3,4,5})); //a
        assertThat(sut.getChooseRange().toArray(), is(new int[]{1,3,5}));   //b
        
        assertThat(sut.getChooseRange().toArray(), is(new int[]{1,3,5})); //a
        assertThat(sut.getChooseRange().toArray(), is(new int[]{1,2,3,4}));   //b
    }
    
}
