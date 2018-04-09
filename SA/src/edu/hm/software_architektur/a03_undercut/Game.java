package edu.hm.software_architektur.a03_undercut;

/**
 *
 * @author Edo
 */
public interface Game {
    
    static Game make(String specification) throws ReflectiveOperationException {
        return Factory.<Game>make(specification);
    }
    
    void play(GameRule gameRule, Parameters parameter, Connection connection);
    
    Game giveScoreA(int num);
    
    Game giveScoreB(int num);
    
    int getRoundsPlayed();
    
    int getScoreA();
    
    int getScoreB();
    
    GameRule getGameRules();
    
    Parameters getParameters();
    
    String getState();
    
}
