package chap12;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class FunctionTest {

	public static void main(String[] args) {
	Runnable myRunFn = () -> System.out.println("람다식 : 단순호출");
	myRunFn.run();
	recevieTest(myRunFn);
	
	Supplier<Integer> mySupplier = ()-> (100+200);
	System.out.println(mySupplier.get());
	
	Consumer<Integer> myConsumer = (x) -> System.out.println(x*2);
	myConsumer.accept(100);
	
	Function<Integer, String> myFunction = (x) -> "인자값:"+x+"이 있고 반환값 문자열이 넘어온다 ";
	System.out.println(myFunction.apply(100));
	
	
	
	}
	public static void recevieTest(Runnable fn) {
		System.out.println("----함수를 인자로 넘겨받았음");
		fn.run();
	}
}
