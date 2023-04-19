package chap13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class Sample11StreamOper7 {

	public static void main(String[] args) {
		List<Score> scores = Arrays.asList(
				new Score("길순이1", 61, 71, 81), 
				new Score("길순이2", 62, 72, 82), 
				new Score("길순이3", 100, 100, 61) 
				);
			System.out.println("---- 국어 최저 점수인 학생");
			scores.stream().collect(Collectors.minBy(Comparator.comparing(Score::getKor)))
			.ifPresent(System.out::println);
		
			System.out.println("---- 영어 최 점수인 학생");
			scores.stream().collect(Collectors.maxBy(Comparator.comparing(Score::getEng)))
			.ifPresent(System.out::println);
			
			System.out.println("---- 이름순으로 제일 빠른 학생");
			scores.stream().collect(Collectors.minBy(Comparator.comparing(Score::getName)))
			.ifPresent(System.out::println);
	
			System.out.println("---- 이름순으로 제일 느린 학생");
			scores.stream().collect(Collectors.maxBy(Comparator.comparing(Score::getName)))
			.ifPresent(System.out::println);
	
			System.out.println("---- joining()");
			List<String> list_string =  Arrays.asList("py","java","c");
			// 단순 조합
			String a = list_string.stream().collect(Collectors.joining());
			System.out.println(a);
			
			// 요소와 요소를 구분자로 구분 
			String b = list_string.stream().collect(Collectors.joining(", "));
			System.out.println(b);
			
			// 구분자, 접두사, 접미사 
			String c = list_string.stream().collect(Collectors.joining(", ","프로그랴망 언어에는 ", " 등이 있습니다."));
			System.out.println(c);
	
			
			// 그룹핑 : groupingBy()
			// 수학 점수를 기준으로 A, B, C, D, F 학점으로 분류 groupingBy() 조건에 맞는 객체들 끼리 모아주는 역활  
			// value인자를 list통 배열로 받아서 여러가지 값을 다룰수 있다. 
			Map<String, List<Score>> result = scores.stream().collect(Collectors.groupingBy(score ->{	
				return (score.getMath()> 90 ? "A" : 
							score.getMath() > 80 ? "B" : 
								score.getMath()> 70 ? "C": 
									score.getMath() > 60 ? "D" : "F");
			}));
			Map<String, List<Score>> result1 = scores.stream().collect(Collectors.groupingBy(score ->{	
				return (score.getEng()> 90 ? "A" : 
					score.getEng() > 80 ? "B" : 
						score.getEng()> 70 ? "C": 
							score.getEng() > 60 ? "D" : "F");
			}));
			
			result.keySet().forEach(key->{
				System.out.printf("** 수학 %s학점\n",key);
				List<Score> score = result.get(key); 
//				System.out.println(score.toString());
				score.stream().forEach((x)->{System.out.println(x.getName());
			});
//			System.out.println(result);
			});
			
			System.out.println("--------------");
			result1.keySet().forEach(key->{
				System.out.printf("** 영어 %s학점\n",key);
				List<Score> score = result1.get(key); 
//				System.out.println(score.toString());
				score.stream().forEach((x)->{System.out.println(x.getName());
				});
//			System.out.println(result);
			});
	}
}




	


























