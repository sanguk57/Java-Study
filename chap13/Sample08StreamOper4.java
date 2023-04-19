package chap13;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Sample08StreamOper4 {
	public static void main(String[] args) {
		
		List<String> local = Arrays.asList("서울","대전","대구","광주","부산","양산","제주");
		
		List<String> reversedLocals = local.stream().
				collect(
						Collectors.collectingAndThen(
								Collectors.toList(), // 처음 인자 
								(city) -> {	Collections.reverse(city); // 두번째 인자 
						return city.stream();
		})
	).collect(Collectors.toList());
		
		System.out.println(local);
	System.out.println(reversedLocals);
	}

}
