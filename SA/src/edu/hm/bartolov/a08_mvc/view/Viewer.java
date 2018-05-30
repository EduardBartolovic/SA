package edu.hm.bartolov.a08_mvc.view;

import edu.hm.bartolov.a08_mvc.datastore.readonly.Offerings;
import java.util.Observable;
import java.util.Observer;


public interface Viewer extends Observer{
    
    public static Viewer make(String typekey,Offerings offerings,Object... args){
        if(typekey.equals("dummy"))
            return (Observable o, Object arg) -> {};
        if(typekey.equals("spectator"))
            return new Spectator();
        
        return null;
    }
    
}
