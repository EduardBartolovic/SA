package edu.hm.gaul.DeepPackageAnonymous;
public class DeepPackageAnonymous {
	DeepPackageAnonymous(){}
	public DeepPackageAnonymous(int i){}
	private Runnable r = new Runnable() {
		public void run() {
			System.out.println("42");
		}
	};
	public static void main(String... args) {
		new DeepPackageAnonymous().doStu$$1(2);
	}
	void doStu$$1(int a) {
		new DeepPackageAnonymous().r.run();
	}
}