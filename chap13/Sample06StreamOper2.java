package chap13;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Sample06StreamOper2 {

	public static void main(String[] args) {
		int sum1=0;
		OptionalInt sum2; // 초기값 없이 누적함수를 구현해서 반환 
		OptionalInt sum3;
		
		sum1 = IntStream.rangeClosed(6, 10).reduce(0, Integer::sum);
		System.out.println("1. "+sum1);
		
		// 첫번째 데이터가 초기값으로 결정되는 구조 (by Optional) 
		sum2 =  IntStream.rangeClosed(6, 10).reduce(Integer::sum); 
		System.out.println("2. "+sum2.getAsInt()+", "+sum2);
		// 초기화
		sum3 = OptionalInt.of(10); // 10이라는 값을 가지는 옵티날객체 생생 new OptionalInt(10);
//		OptionalInt sum3 = OptionalInt.empty();
		if(sum3.isEmpty()) {
			System.out.println("sum3값이 비어있음");
		}
		if(sum3.isPresent()) { // 값이 있을 경우 true반환 
			System.out.println("값이 있음:"+sum3.getAsInt());
		}
		else {
			System.out.println("값이 없음");
		}
		
		IntStream.rangeClosed(1, 10)
			.reduce(Integer::sum)
			// 최종연산 결과가 있으면 (true 이면) 처리  
			.ifPresent(System.out::println);
		
	}	
	
}