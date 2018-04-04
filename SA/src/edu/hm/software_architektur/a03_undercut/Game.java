package edu.hm.software_architektur.a03_undercut;

/**
 *
 * @author Edo
 */
public interface Game {
    
    void play(Parameters parameter);
    
    boolean giveScoreA(int num);
    
    boolean giveScoreB(int num);
    
    int getRoundsPlayed();
    
    int getScoreA();
    
    int getScoreB();
    
}
