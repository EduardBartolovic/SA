public class WhileTrue2 {
    public static void main(String... args) {
	while (args[0] != null) {
            System.out.println("Hello, World!");
            break;
        }
    }
}