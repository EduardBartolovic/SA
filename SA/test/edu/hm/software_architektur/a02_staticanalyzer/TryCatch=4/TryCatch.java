public class TryCatch {
    public static void main(String... args) {
        try {
            if(args.length == 0)
                throw new RuntimeException();
        }
        catch(Exception ex) {
            System.out.println("foo");
        }
    }
}
