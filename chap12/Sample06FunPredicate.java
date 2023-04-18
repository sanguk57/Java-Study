package chap12;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Sample06FunPredicate {

	public static void main(String[] args) {
		// 입력된 숫자가 짝수, 홀수 판별 (비교연산자 사용)
		Predicate<Integer> isEven = s -> (s%2) == 0;
		Predicate<Integer> isOdd = isEven.negate(); // negate() : 반대 
		
		Scanner sc = new Scanner(System.in);
//		sc.hasNextInt();
		System.out.println("숫자:");
		int num = sc.nextInt();
		sc.close();
//		System.out.println(isOdd.test(num)? "짝수" :"홀수" );
		
		if(isEven.test(num)) {
			System.out.println("짝수를 입력하였습니다.");
		}
		if(isOdd.test(num)) {
			System.out.println("홀수를 입력하였습니다. ");
		}
		
		System.out.println("===== isEqual()");
		// 일치 여부 테스트 
		List<Integer> luckNo = Arrays.asList(5, 12, 25, 26, 38, 45);
		Predicate<List<Integer>> isLucky = Predicate.isEqual(luckNo);
		
		List<Integer> myNo = Arrays.asList(5, 12, 25, 26, 38, 41);
		if(isLucky.test(myNo)) {
			System.out.println("1등 당첨 축하");
		}
		else {
			System.out.println("1등이 아님");
		}
		
		// 크기 비교 
		int a = 12;
		int b = 33;
		Predicate<Integer> isMin = s->s>10;
		Predicate<Integer> isMax = s->s<20;
		System.out.println(isMin.and(isMax).test(a));
		System.out.println(isMin.and(isMax).test(b));
	
		int[] no = {1, 3, 6, 8};
		Predicate<Integer> isOdd2 = s -> s%2 == 1; // 홀수판단 
		Predicate<Integer> isMulti = s -> s%3 == 0; // 3의배수 판단 
		
		for(int num1 : no) {
			if(isOdd2.or(isMulti).test(num1)) {
				System.out.printf("%d는 홀수이거나 3의 배수입니다.\n",num1);
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	}

}
