/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hm.software_architektur.a03_undercut.parameter;

import edu.hm.peither_bartolov.a03_undercut.parameter.DefaultParameters;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 *
 * @author Edo
 */
public class DefaultParametersTest {
    
    public DefaultParametersTest() {
    }

    @Test
    public void testGetScoreToWin() {
        final DefaultParameters sut = new DefaultParameters();
        assertThat(sut.getScoreToWin(), is(40));
    }

    @Test
    public void testGetChooseRange() {
        final DefaultParameters sut = new DefaultParameters();
        assertThat(sut.getChooseRange().toArray(), is(new int[]{1,2,3,4,5}));
    }
    
}
