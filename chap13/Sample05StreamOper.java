package chap13;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Sample05StreamOper {

	public static void main(String[] args) {
		// 스트림 연산자 : 중간연산, 최종연산 
		// 스트림을 생성한 뒤 중간에 스트림의 내부 반복 중에 연산작업(중간연산) 
		// 최종연산을 진행하는 형태 
		
		int[] num = IntStream.rangeClosed(1, 10).toArray();
//		System.out.println(Arrays.toString(num));
		Arrays.stream(num).forEach(System.out::println);
		
		System.out.println("-----");
		Stream.of("홍길동", "김길상", "몰라").forEach(name->System.out.printf("%s ",name));
		System.out.println("\n------");
		
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
		list.stream().forEach(x->System.out.printf("%d ",x));
		
		System.out.printf("\n----parallel(): 성능기준, 순서에 관계없음\n");
		list.stream().parallel().forEach(System.out::println);
		
		System.out.printf("----forEachOrdered(): 성능기준, 순서 보장\n");
		list.stream().parallel().forEachOrdered(System.out::println);
		
		System.out.println("--- reduce()");
		// 스트림 요소들의 합, 최댓값 등을 구하고자 할 경우 사용
		// reduce(초기값, (인자1, 인자2))
		int sum1=0, sum2=0, sum3=0, sum4=0;
		
		for(int i=6; i<=10; i++) {
			sum1 += i;
		}
		System.out.println("sum1 = "+sum1);
		
		sum2 = IntStream.rangeClosed(7, 10).reduce(6, Integer::sum);
		System.out.println("sum2 = "+sum2);

		sum3 = IntStream.rangeClosed(7, 10).reduce(6, (x, y)->x+y);
		System.out.println("sum3 = "+sum3);
		
		sum4 = IntStream.rangeClosed(6, 10).reduce(0, (x, y)->{
			System.out.printf("x : %d, y : %d\n", x, y);
				return x+y;
			});
		System.out.println("sum4 = "+sum4);

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
