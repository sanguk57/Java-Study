package chap13;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Sample13StreamDistictCount {

	public static void main(String[] args) {
		// distinct(), count(), max(), min()
		String[] animals = {"토끼","호랑이","고양이","강아지","고양이"};
		System.out.println("** 기본배열 출력");
		System.out.println(Arrays.toString(animals));
		
		System.out.println("** List");
		List<String> ani1 = Arrays.stream(animals).collect(toList());
		System.out.println(ani1+", "+ani1.toString());
		
		System.out.println("** Set");
		Set<String> ani2 = Arrays.stream(animals).collect(toSet());
		System.out.println(ani2);
		
		// Set => List
		List<String> listToSet = ani2.stream().collect(toList());
		System.out.println(listToSet);
		
		System.out.println("** distinct");
		List<String> ani3 = Arrays.stream(animals).distinct().collect(toList());
		System.out.println(ani3);
		
		// Stream객체에서 제공하는 count(), collect() 메서드에서 Collectors.counting()
		System.out.println(IntStream.range(11, 46).count());
		//---------------------------------//
		List<FreeBoard> boardList = Arrays.asList(
				new FreeBoard(1, "가입인사", "안녕하세요."),
				new FreeBoard(2, "가입인사", "반갑습니다."),
				new FreeBoard(3, "질문있습니다.", "자바가요 잡히나요?")
				);
		boardList.stream().max(Comparator.comparing(FreeBoard::getTitle)).ifPresent(System.out::println);
		boardList.stream().min(Comparator.comparing(FreeBoard::getTitle)).ifPresent(System.out::println);
		boardList.stream().max(Comparator.comparing(FreeBoard::getContents)).ifPresent(System.out::println);
		boardList.stream().min(Comparator.comparing(FreeBoard::getContents)).ifPresent(System.out::println);
		
		long cnt1= boardList.stream().collect(Collectors.counting());
		System.out.println("collect()에서 제공하는 Collectors.count():"+cnt1);
		
		long cnt2 = boardList.stream().count();
		System.out.println("collect()에서 제공하는 count():"+cnt2);
		
		// min(), max()
		List<Integer> num1 = Arrays.asList(10,4,7,56,43,99,124);
		Integer minNum = num1.stream().min(Integer::compare).get();
		System.out.println(num1+", min="+minNum);
		
		List<Score> scores = Arrays.asList(
				new Score("길순이1", 61, 71, 81), 
				new Score("길순이2", 62, 72, 82), 
				new Score("길순이3", 100, 100, 61) 
				);
		
		scores.stream().collect(Collectors.minBy(Comparator.comparing(Score::getMath))).ifPresent(System.out::println);
		
		Score maxMathScore = scores.stream().collect(Collectors.maxBy(Comparator.comparing(Score::getMath))).get();
		System.out.println(maxMathScore);
		// sum()
		// .boxed() : collect() 메서드에서 사용
		// int, long, short, byte, double, ... 을  Integer, Long, Double요소로 박싱해서 스트림으로 생성 
		int sum1 = IntStream.rangeClosed(1, 100).boxed().reduce(0, (a,b)->a+b);
		System.out.println(sum1);
	
		int sum2 = IntStream.rangeClosed(1, 100).boxed().reduce(0, Integer::sum);
		System.out.println(sum2);

		int sum3 = IntStream.rangeClosed(1, 100).skip(10)//10개 건너뛰
							.reduce(0, Integer::sum);
		System.out.println(sum3);
		
		IntStream.rangeClosed(1, 100).average().ifPresent(System.out::println);
		double avg = IntStream.rangeClosed(1, 100).average().getAsDouble();
		System.out.println(avg);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
