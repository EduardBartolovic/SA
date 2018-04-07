public class WhileBoolean {

    public static void main(String... args) {
        boolean bool = true;
        int n = 0;
        while (bool) {
            if (n == 5) {
                break;
            }
            n++;
        }
    }
}
