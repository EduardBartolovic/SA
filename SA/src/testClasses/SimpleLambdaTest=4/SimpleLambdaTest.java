import java.util.function.Function;

public class SimpleLambdaTest {
	public static void main(String[] args){
		executeLambda("Hello", str -> str.chars().sum());
	}

	private static int executeLambda(String str, Function<String,Integer> func){
		return func.apply(str);
	}
}