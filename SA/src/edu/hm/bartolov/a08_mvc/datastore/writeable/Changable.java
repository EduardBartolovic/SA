package edu.hm.bartolov.a08_mvc.datastore.writeable;

/**
 *
 * @author Edo
 */
public interface Changable {
    
    /**
     * set if there has been a change.
     */
    void modified();
    
    /**
     * setting changable.
     * @param changeable 
     */
    void setChangable(MutableOfferings changeable);
    
}
