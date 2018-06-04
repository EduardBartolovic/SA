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

    protected Offerings getDataStore() {
        return dataStore;
    }

    
    public static Viewer make(String typekey,Offerings offerings,Object... args){
        final Viewer viewer;
        if(typekey.equals("dummy")){
            viewer = new Dummy();
        }else if(typekey.equals("spectator")){
            viewer = new Spectator(args);
        }else if(typekey.equals("logger")){
            viewer = new Logger(args);
        }else{
            return null;
        }
        
        
        return viewer;
    }
    
}
