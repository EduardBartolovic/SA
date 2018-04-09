package edu.hm.software_architektur.a03_undercut;

/**
 *
 * @author Felix Peither, Eduard Bartolovic
 */
public interface GameRule {
    
    static GameRule make(String specification) throws ReflectiveOperationException {
        return Factory.<GameRule>make(specification);
    }
    
    int getRoundsPlayed();
    
    int getScoreA();
    
    int getScoreB();
    
    
    
}
