package edu.hm.gaul.DeepPackageAnonymous;
public class DeepPackageFakeAnonym$1 {
	DeepPackageFakeAnonym$1(){}
	public DeepPackageFakeAnonym$1(int i){}
	private Runnable r = new Runnable() {
		public void run() {
			System.out.println("42");
		}
	};
	public static void main(String... args) {
		new DeepPackageFakeAnonym$1().doStu$$1(2);
	}
	void doStu$$1(int a) {
		new DeepPackageFakeAnonym$1().r.run();
	}
}