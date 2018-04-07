import java.awt.List;

public class ExtendsImplements extends List implements Runnable { 

    @Override
    public void run() {
        System.out.println("42");
    }
    
}
