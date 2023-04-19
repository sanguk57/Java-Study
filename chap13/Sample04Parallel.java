package chap13;

import java.util.stream.IntStream;


public class Sample04Parallel {

	public static void main(String[] args) {
		// 병렬 스트림(Parallel Stream)
		
		// 1. 직렬 스트림 테스트 : 단일 쓰레드로 처리  
		long time1 = System.currentTimeMillis();
		IntStream.rangeClosed(65, 74).forEach((x)->{
			System.out.print(Thread.currentThread().getClass());
			System.out.println(" - "+x+", char : "+(char)x);
		}); 
		System.out.println("직렬 스트림시간 -"+(System.currentTimeMillis()-time1));
		
		// 병렬 스트림 테스트 : 다중 쓰레드로 처리, 순서에 상관없이 출력    parallel() : 병렬 스트림 
		long time2 = System.currentTimeMillis();
		IntStream.rangeClosed(65, 74).parallel().forEach((x)->{
			System.out.print(Thread.currentThread().getClass());
			System.out.println(" - "+x+", char : "+(char)x);
		}); 
		System.out.println("병렬 스트림시간 -"+(System.currentTimeMillis()-time2));
		
		// 스트림연산 
		// toArray(), forEach(), forEachOrdered(), reduce(), collect(), toList()
		// toSet(), toCollection(), toMap(), collectingAndThen(), reverse()
		// averageingDouble(),...
		// counting(), maxBy(), minBy(), joining(), reducing()
		// partitioningBy(), distinct(), count(), min(), max(), sum(), average()
		// anyMatch(), allMatch(), noneMatch()
		// findAny(), findFirst()
		// map(), flatMap(), mapToObj(), filter(), sorted(), peek()
		// limit(), skip(),
		
		// 구구단
		IntStream.rangeClosed(2, 9).forEach((x)->{
			System.out.printf("----%d단-----\n",x);
			IntStream.rangeClosed(1, 9).forEach((y)->{
			System.out.printf("%d * %d = %d\n",x,y,x*y);
			});
			
		});
			IntStream.rangeClosed(2, 9).forEach((x)->{
				System.out.printf("-----%d단-----\n",x);
			for(int i=1; i<10; i++)
			System.out.printf("%d * %d = %d\n",x,i,x*i);
	});
	}

}
