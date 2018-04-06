
public class MoreAnd {
    public static void main(String... args) {
        if(args != null && args.length > 0 && args.length > 42 && args.length > 100)
            System.out.println(args[42]);
    }
}
