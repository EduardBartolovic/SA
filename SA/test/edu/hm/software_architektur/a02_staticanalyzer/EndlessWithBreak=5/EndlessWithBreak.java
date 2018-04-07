public class EndlessWithBreak {

    public static void main(String... args) {
        int count = 0;
        int n = 0;
        while (true) {
            if (count == 3) {
                break;
            }
            count++;
        }

        while (n < 10) {
            n++;
        }
    }
}
