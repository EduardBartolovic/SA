public class ImplementsTest implements Runnable {
    public static void main(String... args) {
        new ImplementsTest().run();
    }
    @Override
    public void run() {
        System.out.println();
    }
}
