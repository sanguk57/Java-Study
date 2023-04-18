package chap12;

import java.util.function.Function;
import java.util.function.UnaryOperator;


public class Sample07FunUnaryOperator {

	public static void main(String[] args) {
		UnaryOperator<String> classFile = p -> p+".class"; // 인자값과 반환값이 같을
		System.out.println(classFile.apply("Sample07"));
		
		Function<String, String> sourceFile = s -> s+".java";
		System.out.println(sourceFile.apply("Sample07"));
		
		
	}

}
