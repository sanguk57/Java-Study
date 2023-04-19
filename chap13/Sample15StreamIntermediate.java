package chap13;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Sample15StreamIntermediate {

	public static void main(String[] args) {
		// 중간 연산자(Intermediate operations)
		// map() : 스트림의 요소 하나하나에 연산 결과를 그대로 반환 
		
		// boxed() : Stream을 Integer자료형으로 자동 형 변환, int => Integer(객체화)
		List<Integer> list = IntStream.rangeClosed(1, 10).map(x->x*2).boxed().collect(Collectors.toList());
		System.out.println(list);
		
		List<Score> scores = Arrays.asList(
				new Score("길순이1", 61, 71, 81), 
				new Score("길순이2", 62, 72, 82), 
				new Score("길순이3", 100, 100, 31) 
				);
		scores.stream().map(x->{
			if(x.getKor()<40 || x.getEng()<40 || x.getMath()<40)
				x.setMsg("과락입니다.");
			else if((x.getKor()+x.getEng()+x.getMath())/3 < 60 ){
				x.setMsg("불합격입니다.");
			}
			else {
				x.setMsg("합격입니다.");
			}
			return x;
		}).forEach(System.out::println);
		
		// flatMap() : 여러개의 Stream을 모두 합쳐서 하나의 스트림으로 변환 
		String[] str1 = {"홍길동","홍길수","동길이"};
		String[] str2 = {"홍길동홍","홍길수홍","동길이홍"};
	
		Stream<String[]> strm = Stream.of(str1, str2);
		List<String> list2 = strm.flatMap(x->Arrays.stream(x)) // Arrays.stream(배열을 스트림으로 만든다.) 배열차제로는 스트림에서 못쓰기 때문 Arrays::stream도 가
								 .collect(Collectors.toList());
		System.out.println(list2.toString()); 
		
		// mapToObj() : 자료형을 변경하고자 할 경우
		Map<Boolean, List<Long>> m1 = IntStream.range(1, 10).mapToLong(x->x).boxed() // 숫자형 타입을 collect()에 전달시 boxed()메서드 처리
											   .collect(Collectors.partitioningBy(i->i%2==0));
		System.out.println(m1.get(true));

		Map<Boolean, List<Long>> m2 = IntStream.range(1, 10).mapToLong(Long::new).boxed() 
				.collect(Collectors.partitioningBy(i->(i%3==0 && i%2 == 0)));
		System.out.println(m2.get(true));
	}

}

/*
 중간 연산자(Intermediate operations)
 실행되지 않아서 '지연(Lazy)연산을 한다'라고도 표
 
 */
