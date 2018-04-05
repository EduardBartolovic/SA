public class MoreOr {
    public static void main(String... args) {
        if(args != null || args.length > 0 || Integer.MAX_VALUE<=42 || 6>42)
            System.out.println(args[42]);
    }
}
