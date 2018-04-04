public class Anonymous {
    private Runnable r = new Runnable() {
        public void run() {
            System.out.println(42);
        }
    };
    
    public static void main(String... args) {
        new Anonymous().r.run();
    }
}
