
package edu.hm.bartolov.a08_mvc.view;

import java.util.Observable;

/**
 *
 * @author Edo
 */
public class Spectator extends Viewer{

    private int counter = 5;
    
    Spectator(Object object) {
        super(null);
        
//        new Thread(()-> {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Spectator.class.getName()).log(Level.SEVERE, null, ex);
//            }
//           update(null,null);
//        }).start();
    }
    
    @Override
    public void update(Observable o, Object arg) {
        if(getDataStore().getBidder()==null){
            if(getDataStore().getStepsRemaining()==5){
                System.out.println(": Mindestangebot ");
            }else if(getDataStore().getStepsRemaining()==4){
                System.out.println(": Mindestangebot "+"bietet jemand?");
            }else if(getDataStore().getStepsRemaining()==3){
                System.out.println(": Mindestangebot noch "+"bietet jemand?");
            }else if(getDataStore().getStepsRemaining()==2){
                System.out.println(": zum Ersten...");
            }else if(getDataStore().getStepsRemaining()==1){
                System.out.println(": zum Zweiten...");
            }else if(getDataStore().getStepsRemaining()==0){
                System.out.println(": keine Gebote, nicht verkauft.");
            }
                
        }else{
            if(getDataStore().getStepsRemaining()==5){
                System.out.println(": "+getDataStore().getBid() + " geboten!");
            }else if(getDataStore().getStepsRemaining()==4){
                System.out.println(": "+getDataStore().getBid() + " geboten, hoere ich mehr?");
            }else if(getDataStore().getStepsRemaining()==3){
                System.out.println(": noch "+getDataStore().getBid() + " geboten, hoere ich mehr?");
            }else if(getDataStore().getStepsRemaining()==2){
                System.out.println(": "+getDataStore().getBid() + " zum Ersten...");
            }else if(getDataStore().getStepsRemaining()==1){
                System.out.println(": "+getDataStore().getBid() + " zum Zweiten...");
            }else if(getDataStore().getStepsRemaining()==0){
                System.out.println(": "+getDataStore().getBid() + " zum Dritten, verkauft!");
            }
        }
           
    }
    
}
