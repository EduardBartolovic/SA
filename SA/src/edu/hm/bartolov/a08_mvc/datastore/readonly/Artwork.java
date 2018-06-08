package edu.hm.bartolov.a08_mvc.datastore.readonly;

/**
 * 
 * @author Computer
 */
public interface Artwork {
    
    /**
     * 
     * @return 
     */
    String getTitle();
    /**
     * 
     * @return 
     */
    int getInitialPrice();
   
    /**
     * 
     */
    boolean isAuctioned();
   
    /**
     * 
     * @return 
     */
    String getBuyer();
    
    /**
     * 
     * @return 
     */
    int getSoldPrice();
    
}
