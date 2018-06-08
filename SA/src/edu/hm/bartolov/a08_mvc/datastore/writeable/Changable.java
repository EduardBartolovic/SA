package edu.hm.bartolov.a08_mvc.datastore.writeable;

/**
 *
 * @author Edo
 */
public interface Changable {
    
    /**
     * set if there has been a change.
     */
    void setChanged();
    
    /**
     * setting changable.
     * @param changeable 
     */
    void setChangable(MutableOfferings changeable);
    
}
