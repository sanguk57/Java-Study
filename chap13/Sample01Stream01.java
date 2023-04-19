package chap13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Sample01Stream01 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		var list = Arrays.asList(1,2,3,4,5,3,2,3,4);
		
		System.out.println("** HasSet을 활용한 중복 제거");
		@SuppressWarnings({ "rawtypes" })
		var list1 = new ArrayList(new HashSet<Integer>(list));
		// 컬렉션 내부로 스트림을 가진다.
		list1.forEach(System.out::println);
//		list1.forEach(data->System.out.println(data));
		
		System.out.println("==== Stream을 활용한 중복제거");
		// 컬렉션에서는 Stream으로 전환 distinct() 중복제거 
		list.stream().distinct().forEach(System.out::println); 
	
		String[] strArr = {"홍길동", "홍길순", "동길이", "동길이홍"};
		System.out.println(Arrays.toString(strArr));
	
		int[] intArr = {3,6,9};
		double[] floatArr = {3.1, 5.2, 10.2};
	
		// 스트림 생성
		Stream<String> strStm = Arrays.stream(strArr);
		IntStream intStm = Arrays.stream(intArr);
		DoubleStream doubleStm = Arrays.stream(floatArr);
		
		// 3. 출력
		strStm.forEach(System.out::println);
//		strStm.forEach(System.out::println); // 반복사용시 에러 1회용 iterator
		intStm.forEach(System.out::println);
		doubleStm.forEach(System.out::println);
		
		// 4. 스트림 메서드 통해 바로 출력
		Arrays.stream(strArr).forEach(System.out::println);

		
	}

}
