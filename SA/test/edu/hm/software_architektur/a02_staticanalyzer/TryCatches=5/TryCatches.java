public class TryCatches {
    public static void main(String... args) {
        try {
            if(args.length == 0)
                throw new RuntimeException();
        }
        catch(RuntimeException rte) {
            System.out.println("bar");
        }
        catch(Exception ex) {
            System.out.println("foo");
        }
    }
}
