public class MoreOr {
    public static void main(String... args) {
        if(args != null || args.length > 0 || args.length > 1 || args.length == 100)
            System.out.println(args[42]);
    }
}
