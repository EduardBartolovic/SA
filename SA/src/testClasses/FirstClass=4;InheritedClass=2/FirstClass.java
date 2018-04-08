
public class FirstClass extends InheritedClass {
	@Override public void doThis(int a) {
		System.out.println(a);
	}
	@Override public double doThat(Object b) {
		return (double)b;
	}
	@Override protected Object andThis(float c) {
		return c;
	}
}