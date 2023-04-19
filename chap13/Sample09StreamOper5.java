package chap13;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Data;
import lombok.RequiredArgsConstructor;

public class Sample09StreamOper5 {

	public static void main(String[] args) {
		List<Score> scores = Arrays.asList(
				new Score("길순이1", 61, 71, 81), 
				new Score("길순이2", 62, 72, 82), 
				new Score("길순이3", 100, 100, 61) 
				);
		double avgMath = scores.stream().collect(Collectors.averagingDouble(Score::getMath));
		System.out.printf("평균 수학점수는 %.2f",avgMath);
		
		
	}
	
}
@Data
@RequiredArgsConstructor // final인자만 생성자 인자로 받겠다 
class Score{
	private final String name;
	private final int kor;
	private final int eng;
	private final int math;
	private String msg; 
}
