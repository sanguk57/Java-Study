package chap13;

import static java.util.stream.Collectors.partitioningBy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Sample12StremPartitionBy {
	public static void main(String[] args) {
		// partitioningBy()메서드는 groupingBy()유사기능
		// Function은 스트림으로 넘어온 요소를 특정 자료형으로 반환
		// Predicate함수형 인터페이스를 인자를 사용 Boolean자료형으로 변환
		List<Score> scores = Arrays.asList(
				new Score("길순이1", 61, 71, 81), 
				new Score("길순이2", 62, 72, 82), 
				new Score("길순이3", 100, 100, 61) 
				);
		// 수학 80점 이상인 사람과 그렇지 않은 사람을 구분
		Map<Boolean, List<Score>> list_result = scores.stream().collect(partitioningBy(s->{
			return (s.getMath()>80)? true: false;
		}));
		
		System.out.println("** 수학점수 80점 이상인 고득점자 명단");
		List<Score> list = list_result.get(true);
		List<Score> list1 = list_result.get(false);
		for(Score score : list) {
			System.out.println(score.getName()+", "+score.getMath());
		}
		
		// 수학 80이상인 사람과 그렇지 않은 사람은 각각 몇명인가?
		Map<Boolean, Long> count = scores.stream().collect(Collectors
												  .partitioningBy(
												  r -> r.getMath()>80 ? true : false, Collectors.counting()));

		System.out.printf("80점 미만 : %d명 이고 80점 이상 : %d명 이다",count.get(false), count.get(true));
		
		System.out.printf("80점 미만 : %d명 이고 80점 이상 : %d명 이다",list1.stream().collect(Collectors.counting()),
				list.stream().collect(Collectors.counting()));
	}		
			
}
