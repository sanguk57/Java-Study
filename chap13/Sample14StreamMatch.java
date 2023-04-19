package chap13;

import java.util.Arrays;
import java.util.List;

public class Sample14StreamMatch {
	public static void main(String[] args) {
		// anyMatch(), allMatch(), noneMatch()
		
		List<Score> scores = Arrays.asList(
				new Score("길순이1", 61, 71, 81), 
				new Score("길순이2", 62, 72, 82), 
				new Score("길순이3", 100, 100, 31) 
				);
		
		boolean result1 = scores.stream().anyMatch(x->x.getMath()>39); // OR 연산자 기능 
		System.out.println("수학 과락이 아닌 사람이 있나요?"+(result1 ? "예" : "없음"));
		
		boolean result2 = scores.stream().allMatch(x->x.getKor()>39); // AND 연산자 기능
		System.out.println("국어 과락이 없나요? "+(result2 ? "예":"아니요"));
		
		boolean result3 = scores.stream().noneMatch( x-> x.getEng() > 39); // 모든요소가 거짓조건이면 true반환 
		System.out.println("영어는 모두 과락인가요 ?"+(result3 ? "에":"아니요"));
		
		List<Integer> list = Arrays.asList(4,6,2,8,10);
		System.out.println(list);
		
		// 요소들 중에 제일 먼저 찾은 요소를 추출
		System.out.println("---- findAny()");
		list.stream().findAny().ifPresent(System.out::println);
		System.out.println("---- findFirst()");
		list.stream().findFirst().ifPresent(System.out::println);
		
		System.out.println();
		list.stream().filter(x-> x>2).findAny().ifPresent(System.out::println);
		// 병렬 쓰레드 영향 받음 
		list.parallelStream().filter(x-> x>2).findAny().ifPresent(System.out::println);
		
		// 요소중 첫번째 요소 출력 
		list.stream().filter(x -> x>2).findFirst().ifPresent(System.out::println);
		// 병렬에 상관없이 첫번째 요소 출력  
		list.parallelStream().filter(x -> x>2).findFirst().ifPresent(System.out::println);
	}
}
/*
 
 Predicate함수형 인터페이스를 사용 : 1개 매개변수, boolean반환
 
 anyMatch() : 스트림 요소중에서 하나이상이 조건에 만족하면 true반환 
 allMatch() : 스트림 요소 모두가 조건에 만족하면 true반환 
 noneMatch() : 스트림 요소 모두가 조건에 만족하지 않으면 true반환 
  
 findAny() : 스트림 요소중에 조건에 맞는 첫번째 요소를 찾는 메서드 
 findFirst() : 스트림 요소중에 첫번째 요소를 찾는 메서드
 
 */