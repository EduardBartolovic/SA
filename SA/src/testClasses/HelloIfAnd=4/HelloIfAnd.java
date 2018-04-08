public class HelloIfAnd {
    public static void main(String... args) {
        if(args != null && args.length > 0)
            System.out.println(args[0]);
    }
}
