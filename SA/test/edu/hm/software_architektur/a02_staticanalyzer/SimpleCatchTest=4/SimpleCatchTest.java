public class SimpleCatchTest {
	public static void main(String[] args) {
		try{
			System.out.println(args[0]);
		} catch (Exception e){
			System.out.println("An exception occurred.");
		}
		try {
			System.out.println(args[1]);
		} catch (Exception e){
			System.out.println("An exception occurred.");
		}
	}
}