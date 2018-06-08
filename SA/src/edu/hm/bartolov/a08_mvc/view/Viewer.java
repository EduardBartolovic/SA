package edu.hm.bartolov.a08_mvc.view;

import edu.hm.bartolov.a08_mvc.datastore.readonly.Offerings;
import java.io.PrintWriter;
import java.util.Observer;


public abstract class Viewer implements Observer{
//    /**
//     * 
//     */
//    private final Offerings dataStore;
//
//    /**
//     * 
//     * @param dataStore 
//     */
//    protected Viewer(Offerings dataStore) {
//        this.dataStore = dataStore;
//        dataStore.addObserver(this);
//    }
//
//    /**
//     * 
//     * @return 
//     */
//    protected Offerings getDataStore() {
//        return dataStore;
//    }
    
    /**
     * 
     * @param typekey
     * @param offerings
     * @param args
     * @return 
     */
    public static Viewer make(String typekey,Offerings offerings,Object... args){
        PrintWriter pw = new PrintWriter(System.out);
        final Viewer viewer;
        switch (typekey) {
            case "dummy":
                viewer = new Dummy();
                break;
            case "spectator":
                viewer = new Spectator(offerings, pw);
                break;
            case "logger":
                viewer = new Logger(offerings);
                break;
            default:
                return null;
        }
        
        
        return viewer;
    }
    
}
