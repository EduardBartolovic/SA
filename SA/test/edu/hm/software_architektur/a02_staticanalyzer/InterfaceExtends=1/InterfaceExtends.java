import java.util.Collection;
public interface InterfaceExtends extends Collection{
    void hallo();
    
    default void hallo3(){
        System.out.println("void");
    }
}
