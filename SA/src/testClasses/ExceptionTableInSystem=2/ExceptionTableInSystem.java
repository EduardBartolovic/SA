public class ExceptionTableInSystem {

    public static void main(String... args) {

        System.out.println("Exception table:");

        try {
            if(args.length == 0)
                throw new RuntimeException();
        }
        catch(Exception ex) {
            System.out.println("foo");
        }
    }

}
