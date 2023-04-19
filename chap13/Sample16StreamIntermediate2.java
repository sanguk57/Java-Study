package chap13;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Sample16StreamIntermediate2 {

	public static void main(String[] args) {
		// 중간 연산 : filter()
		// 원하는 데이터만 필터링해서 요소를 제거할 경우 사용 
		
		List<Integer> list1 = Arrays.asList(1,3,5,7,9);
		List<Integer> list2 = Arrays.asList(2,4,6,8,10);
		
		List<Integer> list3 = Stream.of(list1, list2).flatMap(List::stream).filter(x->x%3==0).collect(Collectors.toList());
		System.out.println(list3);
		
		List<String> str_list = Arrays.asList("RED","bad","BED","Wed","red");
		// "abcdef".indexOf("C")=>2 : 문자가 포함된 인덱스 위치
		str_list.stream().filter(x -> 0 < x.toUpperCase().indexOf("ED")).forEach(System.out::println);
		
		System.out.println("ED가 포함된 단어");
		// 함수형 인터페이스 정의 : 1개의 매개변수, boolean반환 타입 
		Predicate<String> fn1 = (x)-> 0 < x.toUpperCase().indexOf("ED");
		str_list.stream().filter(fn1).forEach(System.out::println);
		
//		System.out.println(fn1.test("daskads;ed"));
		
		System.out.println("ED가 포함되어 있지 않은 단어");
		// 함수형 인터페이스 정의 : 1개의 매개변수, boolean반환 타입 
		Predicate<String> fn2 = Predicate.not(fn1);
		str_list.stream().filter(fn2).forEach(System.out::println);
		
		// sorted() : 기본 정렬 asc
		Integer[] int1 = {1,3,5,7,9}; 
		Integer[] int2 = {2,4,6,8,10};
		
		Stream<Integer[]> strm1 = Stream.of(int1, int2);
		List<Integer> rs_list = strm1.flatMap(Arrays::stream) // Stream<Array> 과 같다 
				.sorted().collect(Collectors.toList());
		
		System.out.println(rs_list);

		Stream<Integer[]> strm2 = Stream.of(int1, int2);
		List<Integer> rs_list2 = strm2.flatMap(Arrays::stream).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		
		System.out.println(rs_list2);
		
		List<Score> scores = Arrays.asList(
				new Score("동길이", 61, 71, 81), 
				new Score("길동이", 62, 72, 82), 
				new Score("삼순이", 100, 100, 31) 
				);
		System.out.println("** 이름 순으로 순차정렬");
		List<Score> sc_list = scores.stream().sorted((x,y)-> x.getName().compareTo(y.getName())).collect(Collectors.toList());
		sc_list.forEach(System.out::println);
		
		System.out.println("** 영어점수가 높은순");
		//  x(this) - y : 순차  y - x(this) : 역순 
		List<Score> eng_list = scores.stream().sorted((x,y)-> y.getEng()-(x.getEng())).collect(Collectors.toList());
		eng_list.forEach(System.out::println);
		
		// Comparable 인터페이스를 이용한 정렬 
		
		List<ScoreBoard> scoreBoards = Arrays.asList(
				new ScoreBoard("동길이", 61, 71, 81), 
				new ScoreBoard("길동이", 62, 72, 82), 
				new ScoreBoard("삼순이", 100, 100, 31) 
				);
		scoreBoards.stream().sorted().collect(Collectors.toList()).forEach(System.out::println);
		
		// distinct()
		List<Integer> numList = Arrays.asList(3,6,9,3,6,9,1,2,3);
		// 중복 제거
		numList.stream().distinct().sorted().forEach(System.out::println);
		
		// peek() : 중간연산 중에 중간에 처리된 요소의 값을 확인하고 싶을때 적용
		Stream.of("mouse","cow","horse","monkey").peek(x->System.out.println("처리전 요소 : "+x)).map(String::toUpperCase).peek(x->System.out.println("처리된 요소 : "+x)).forEach(System.out::println);
		
		// limit() : 스트림요소의 처음부터 몇개까지만 처리할 때 사용  
		// skip() : 처음부터 n개 건너뛰고 이후의 요소부터 처리할 때 사용  
		// 선착순 3명 
		Stream.of("홍길동","홍길순","동길이홍","동순이홍","삼순이").limit(3).forEach(System.out::println);
		// 총 7경기 중 앞 2경기는 연습경기
		Map<String, Long> info = Stream.of("페","승","패","승","승","승","패").skip(2).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())); 
		System.out.println(info);
		System.out.println(info.get("승"));
		System.out.println(info.get("패"));
		
		// generate() : 요소를 무한정 비순차적으로 생성할 때 사용 
		Stream.generate(Math::random).map(n->n*9+1).map(Math::round).limit(10).sorted().forEach(System.out::println);
		
		// 랜덤 키값을 생성할 때 UUID을 사용 (중복성 없는 숫자 발생)
		Stream.generate(UUID::randomUUID).limit(10).forEach(System.out::println);
	}

}

@Data
@AllArgsConstructor
class ScoreBoard implements Comparable<ScoreBoard> {
	private String name;
	private int score1;
	private int score2;
	private int score3;
	
	@Override
	public int compareTo(ScoreBoard o) {
		// 순차(오름차순)
//		return this.getName().compareTo(o.getName());
		// 역순 (내림차순)
		return o.getName().compareTo(this.getName());
		// 숫자 타입
		// 오름차순
//		return this.getScore1() - o.getScore1();
		// 내림차순
//		return o.getScore1() - this.getScore1();
		
	}
	
}





































