package edu.hm.software_architektur.a03_undercut;

/**
 *
 * @author Edo
 */
public class MyGame implements Game{
    
    private GameRule gameRule;
    
    private Parameters parameter;
    
    private Connection connection;
    
    private String state;
    
    private int scoreA;
    
    private int scoreB;
    
    private int round;
    
    public MyGame(){
        this(new MyGameRules(), new MyParameters());
    }

    public MyGame(GameRule gameRule, Parameters parameter) {
        this.parameter = parameter;
        this.gameRule = gameRule;
        scoreA = 0;
        scoreB = 0;
        round = 0;
        state = "running";
    }
    
    @Override
    public void play(GameRule gameRule, Parameters parameter, Connection connection) {
        this.parameter = parameter;
        this.gameRule = gameRule;
        this.connection = connection;
        
        connection.openConnection();
 
    }

    @Override
    public Game giveScoreA(int num) {
        scoreA += num;
        return this;
    }

    @Override
    public Game giveScoreB(int num) {
        scoreB += num;
        return this;
    }

    @Override
    public int getRoundsPlayed() {
        return round;
    }

    @Override
    public int getScoreA() {
        return scoreA;
    }

    @Override
    public int getScoreB() {
        return scoreB;
    }

    @Override
    public GameRule getGameRules() {
        return gameRule;
    }

    @Override
    public Parameters getParameters() {
        return parameter;
    }

    @Override
    public String getState() {
        return state;
    }

    
    
    
}
