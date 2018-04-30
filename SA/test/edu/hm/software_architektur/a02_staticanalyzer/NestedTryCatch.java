package edu.hm.software_architektur.a02_staticanalyzer;

public class NestedTryCatch {
    public static void main(String... args) {
        try {
            if(args.length == 0)
                throw new RuntimeException();
        }
        catch(RuntimeException rte) {
            try {
                if(args.length == 0)
                    throw new RuntimeException();
            }
            catch(RuntimeException rt2) {
                System.out.println("bar");
            }
            catch(Exception ex) {
                System.out.println("foo");
            }
        }
        catch(Exception ex) {
            System.out.println("foo");
        }
    }
}
