package edu.hm.bartolov.a08_mvc.view;

import edu.hm.bartolov.a08_mvc.datastore.readonly.Offerings;
import java.util.Observer;


public abstract class Viewer implements Observer{
    
    private final Offerings dataStore;

    protected Viewer(Offerings dataStore) {
        this.dataStore = dataStore;
        dataStore.addObserver(this);
    }

    protected Offerings getDataStore() {
        return dataStore;
    }
    
    public static Viewer make(String typekey,Offerings offerings,Object... args){
        final Viewer viewer;
        switch (typekey) {
            case "dummy":
                viewer = new Dummy();
                break;
            case "spectator":
                viewer = new Spectator(offerings);
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
