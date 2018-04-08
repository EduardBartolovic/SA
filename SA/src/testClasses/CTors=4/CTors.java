public class CTors {
	private int a = 0;
	CTors(){
		a = 2;
	}
	public CTors(int a) {
		this.a = a;
	}
	public CTors(int a, int b) {
		this.a = a/b;
	}
	private CTors(int a, int b, int c) {
		this.a = a+b+c;
	}
}