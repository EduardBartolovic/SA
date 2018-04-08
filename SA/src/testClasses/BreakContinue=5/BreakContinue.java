public class BreakContinue {
    public static void main(String... args) {
        while(args.length > 0) {
            if(args.length == 0)
                break;
            if(args.length < 0)
                continue;
            System.out.println(1);
        }
    }
}
