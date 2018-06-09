
package edu.hm.bartolov.a08_mvc.control;

/**
 *
 * @author Eduard
 */
public class RobotTrader extends Controller{
    
    private final String[] millis;

    public RobotTrader(String... millis) {
        this.millis = new String[millis.length];
        System.arraycopy(millis, 0, this.millis, 0, millis.length);
    }
    
    
}
