public class WhileTrue3 {
    public static void main(String... args) {
	while (true) {
            System.out.println("Hello, World!");
			if(args[0] != null)
				break;
        }
    }
}