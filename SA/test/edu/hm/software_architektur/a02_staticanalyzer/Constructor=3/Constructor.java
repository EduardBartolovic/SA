public class Constructor {
    int value1;
    int value2;

    public Constructor(int val) {
        value1 = val;
    }

    public Constructor(int val1, int val2) {
        value1 = val1;
        value2 = val2;
    }

    public static void main(String... args) {
        System.out.println("Constructor yay");
    }
}
