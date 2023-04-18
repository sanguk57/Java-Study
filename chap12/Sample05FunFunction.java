package chap12;

import java.util.function.Function;

public class Sample05FunFunction {

	
	public static void main(String[] args) {
		
		int myMoney = 10000;
		
		// 10%세금을 남부하는 함수정의 
		Function<Integer, Integer> work = (money)-> {
				System.out.printf("* [%d]세금을 납부합니다.", (int)(money*0.1));
				return (int)(money-money*0.1);
		// 수입금을 더하는 함수정의 
	};
	Function<Integer, Integer> befor = (incon)-> {
		System.out.printf("* [%d]수입이 발생 했습니다.",incon);
		return incon;
	};
	myMoney = work.apply(myMoney);
	System.out.println(myMoney);
	
	myMoney += work.compose(befor).apply(300000);
	System.out.println(myMoney);
	
	System.out.println("------");
	// 입력된 문자열 숫자로 변환 : "123" -> 123
	Function<String, Integer> trans01 = i -> {
		System.out.println("-> 입력된 문자열 숫자로 변환합니다.");
		return Integer.parseInt(i);
	};
	// 숫자 -> 문자열 반환 : 123 -> "123"
	Function<Integer, String> trans02 = i -> {		
		System.out.println("-> 입력된 숫자를 문자열로 변환합니다.");
		return ""+i ;
	};
	
	if(trans01.andThen(trans02).apply("123") instanceof String) {
		System.out.println("String");
	}
	else System.out.println("Not String");
	
	Function<Integer, Integer> fn = Function.identity();
	System.out.println(fn.apply(12));
	
	
	}
	// 출력양식 함수 정의 
	public static void printInfo(int myMoney) {
		
	}
	
}
