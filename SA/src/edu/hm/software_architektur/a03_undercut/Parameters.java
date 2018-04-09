
package edu.hm.software_architektur.a03_undercut;

/**
 *
 * @author Felix Peither, Eduard Bartolovic
 */
public interface Parameters {
    
    static Parameters make(String specification) throws ReflectiveOperationException {
        return Factory.<Parameters>make(specification);
    }
    
    int getScoreToWin();
    
    int getUpperChoose();
}
