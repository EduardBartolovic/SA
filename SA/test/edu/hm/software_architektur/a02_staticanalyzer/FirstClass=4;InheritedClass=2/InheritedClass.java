
public abstract class InheritedClass {
	abstract void doThis(int a);
	public abstract double doThat(Object b);
	protected abstract Object andThis(float c);

	InheritedClass(){}
	InheritedClass(int b){System.out.println(b);}
}