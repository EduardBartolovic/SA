public interface InterfaceDefault {
	int publicstaticvoid();
	void private_int(int a);
	
	default void doSmth() {
		System.out.println("42");
	}
	default void doSmthAgain(int a) {
		System.out.println(42 - a);
	}
}