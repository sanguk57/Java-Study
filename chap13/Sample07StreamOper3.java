package chap13;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Sample07StreamOper3 {

	public static void main(String[] args) {
		// collect() : 요소하나하나를 매개변수로 받아서 하나로 합쳐서 그 결과값을 반환하는 최종연산 메서드 
		// toList(), toSet(), toCollection(), toMap() : 반환하는 자료형을 의미 
		
		String[] animals = {"토끼", "호랑이", "강아지", "고양이","고양이","강아지","고양이"};
		System.out.println(Arrays.toString(animals));
	
		System.out.println("== List로 변환후 출력");
		// toList() : static 형식이므로 자동 임포트 안됨. 직접 설정함 
		List<String> ani1 = Arrays.stream(animals).collect(Collectors.toList());
		System.out.println(ani1.toString());
		
		// toSet() : 중복제거, 순서에 관계없이  
		System.out.println("== Set로 변환후 출력");
		Set<String> ani2 = Arrays.stream(animals).collect(Collectors.toSet());
		System.out.println(ani2.toString());
		
		// TreeSet() : 중복제거, 정렬
		System.out.println("== TreeSet로 변환후 출력");
		TreeSet<String> ani3 = Arrays.stream(animals).collect(Collectors.toCollection(TreeSet::new));
		System.out.println(ani3.toString());
		
		// toMap(keyMapper, vlaueMapper, mergeFunction(중복일 경우))
		Map<String, Integer> ani4 = ani1.stream().collect(Collectors.
				// toMap(함수1(key값), 함수2(value값), 중복이 되었을때 함수3(value값 계산 글자수*갯수))  
				toMap(Function.identity(), String::length, (x1, x2) -> x1+x2));
		System.out.println(ani4.toString());
		
		String[][][] level = {
				{
					{"홍길동", "초급"}
				},
				{
					{"동길이", "중급"},
				},
				{
					{"동순이", "고급"},
				},
				{
					{"동순이", "중급"},
				},
				{
					{"동순이", "초급"}
				}
		}; 
		
		try {			
			Map map = Arrays.stream(level).collect(Collectors.toMap(x->x[0], x->x[1]));
			System.out.println(map.toString());
		} 
		catch (Exception e) {
			// 중복된 키가 입력될 경우 map처리 방식 
			// 2차원 배열을 스트림인자로 전달시 행단위 전송됨, 0행 ,1행 ,2행, .... n-1행
			// 받는 인자는 행을 전송받음(열값 처리시는 매개변수[index] 형식은 index는 열을 의미) 
			// 3차원 배열이면 면이 넘어간다.
			Map map = Arrays.stream(level).collect(Collectors.toMap(x-> x[0][0], x->x[0][1], (x,y)->x+","+y));
			System.out.println(map.toString());
		}		
	}
}
