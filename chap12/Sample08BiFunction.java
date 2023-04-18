package chap12;

import java.util.function.BiFunction;

public class Sample08BiFunction {

	public static void main(String[] args) {
		// 두개의 매개변수, 반환값 있음.
		BiFunction<Integer, Integer, Integer> fn = (num1, num2) -> num1 + num2;
		BiFunction<Integer, Integer, Integer> fn1 = 
				(start, end) -> {
					int sum=0;
					for(int i=start; i<=end; i++){
						sum +=i; 
					}
				return sum;
		};
		
		int rs = fn.apply(100, 200);
		System.out.println(rs);
		System.out.println("-----");
		System.out.println(fn1.apply(1, 15));
		
		
	}

}
