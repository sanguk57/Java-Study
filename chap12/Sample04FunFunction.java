package chap12;

import java.util.function.Function;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class Sample04FunFunction {

	public static void main(String[] args) {
		// Function<T, R> : 1개의 매개변수, 반환값이 있는 형태
		Function<Integer, String> fn = i->{
			
			return switch (i){
			case 1 : yield"one";
			case 2 : yield "two";
			case 3 : yield"three";
			case 4 : yield "four";
			case 5 : yield "five";
			default : throw new IllegalArgumentException("Unexpected value : "+i);
		};
	

};
		for(int i=1; i<6; i++)
		System.out.println(fn.apply(i));
	
		System.out.println("---- Function 함수형 인터페이스 활용");
		Function<Integer, String> fn2 = num -> {
			String str = "";
			for(AlphaNum a : AlphaNum.values()) {
				if(num == a.getNum()) {
					str = a.toString(); // 상수 이름 변수에 넣는다 하나씩
					break;
				}
			}
				
			return str;
		};
		for(int i=1; i<6; i++)
		System.out.println(fn2.apply(i));
}
}
@Getter
@AllArgsConstructor
enum AlphaNum{
	ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5);
	private final int num;
}
