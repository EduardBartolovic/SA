package edu.hm.bartolov.a08_mvc.view;

import edu.hm.bartolov.a08_mvc.datastore.readonly.Offerings;
import edu.hm.bartolov.a08_mvc.datastore.writeable.MutableOfferings;
import java.util.Observer;


public abstract class Viewer implements Observer{
    
    private final MutableOfferings dataStore;

    public Viewer(MutableOfferings dataStore) {
        this.dataStore = dataStore;
        dataStore.addObserver(this);
    }

    protected MutableOfferings getDataStore() {
        return dataStore;
    }

    
    public static Viewer make(String typekey,Offerings offerings,Object... args){
        switch (typekey) {
            case "dummy":
                return new Dummy();
            case "spectator":
                return new Spectator(args);
            case "logger":
                return new Logger(args);
            default:
                break;
        }
        
        
        return null;
    }
    
}
