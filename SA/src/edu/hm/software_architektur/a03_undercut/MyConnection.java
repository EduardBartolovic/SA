package edu.hm.software_architektur.a03_undercut;

/**
 *
 * @author Edo
 */
public class MyConnection implements Connection{
    
    private int port;
    
    private String ipPlayerOne;
    
    private String ipPlayerTwo;
    
    public MyConnection(int port){
        this.port = port;
    }

    @Override
    public void changePort(int port) {
        this.port = port;
    }

    @Override
    public void openConnection() {
        System.out.print("starting Server on: "+ port);
    }

    
}
