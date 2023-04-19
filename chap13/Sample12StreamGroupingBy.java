package chap13;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class Sample12StreamGroupingBy {
	public static void main(String[] args) {
		// 근태정보를 이용해서 출근, 지각, 결근을 집계
		List<String> list = Arrays.asList(
				"출근", "출근", "지각", "출근", "출근",
				"지각", "출근", "지각", "출근", "출근",
				"출근", "출근", "결근", "출근", "출근",
				"출근", "출근", "지각", "출근", "출근"
				);
		Map<String, Long> info = list.stream()
									 .collect(groupingBy(Function.identity(), counting())
											 ); 
	
		System.out.println(info);
		
	
	}
}
