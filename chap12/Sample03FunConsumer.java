package chap12;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Sample03FunConsumer {

	public static void main(String[] args) {
		// 1개의 매개변수, 반환값이 없는 구조
		
		Consumer<String> c = str -> System.out.println(str.toUpperCase()
				+"는 1개의 매개변수는 있지만 반환할 자료형은 없습니다."); 
		c.accept("Consumer");
	
		Consumer<Integer> c2 = x -> System.out.println(100*x);
		c2.accept(100);
		
		System.out.println("------------- consumer 함수형 타입 인터페이스 활용");
		
		List<Employee> emp = Arrays.asList(
				new Employee(1, "홍길동", 1000),
				new Employee(2, "홍길순", 1200),
				new Employee(3, "홍길이홍", 900),
				new Employee(4, "동순이홍", 800)
				);
		// 함수식을 정의 
		Consumer<Employee> consumer = x -> {
			// 현재 연봉의 * 2 하는 계산식 
			x.setSalary(x.getSalary()*2);
		};
		
		System.out.println("====연봉 2배 인상===");
		// .andThen() : Consumer작업을 순서대로 수행하고 다음 작업을 수행 
//		doubleSalary(emp, consumer.andThen(item -> System.out.println(item)));
		doubleSalary(emp, consumer.andThen(System.out::println));
	}
	private static void doubleSalary(List<Employee> emp, Consumer<Employee> fn) {
		for(Employee e : emp) {
//			System.out.println("-------"+e);
			fn.accept(e); // consumer함수에 값을 인자로 넣어준다 
//			System.out.println(e);
//			System.out.println("-------------");
		}
	}

}

@Data
@AllArgsConstructor
class Employee{
	private int no;
	private String name;
	private double salary;
	
}