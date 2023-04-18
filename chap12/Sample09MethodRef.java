package chap12;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class Sample09MethodRef {

	public static void main(String[] args) {
		// 메서드 참조(Method reference) : 매개변수를 추론하여 메서드를 실행  
		// (Object name)::(Method name)
		// 타입추론  
		
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		list.forEach((x)->System.out.println(x));
		list.forEach(System.out::println);
		
		list.forEach(x->Writer.doWriter(x)); // 람다식 : 인자값, 내부함수 
		list.forEach(Writer::doWriter); // 메서드 참조 : 클래스이름, 메서드 
		
		Function<String, String> helloLambda = (name) -> HelloTo.hello(name);
		Function<String, String> helloLambda1 = HelloTo::hello;
		
		System.out.println(helloLambda.apply("길순이"));
		System.out.println(helloLambda1.apply("동길이"));
		
		// 특정객체의 인스턴스 메서드 참조
		String greeting = "Hello";
		String greeting1 = new String("Hello2");
		
		System.out.println(greeting.toString());
		System.out.println(greeting1); // greeting1.toString()
		
		// String객체의 toString()을 참조하여 객체의 내용이 참조되는 구조 
		writeString(greeting1::toString);
		
		var list1 = Arrays.asList(
			new Person(1, "홍길동1"),
			new Person(2, "홍길동2"),
			new Person(3, "홍길동3"),
			new Person(4, "홍길동4")
			);
		System.out.println("---람다");
		list1.forEach(x->x.toObjString());
		System.out.println("---메서드 참조");
		list1.forEach(Person::toObjString);
	}
	private static void writeString(Supplier<String> supplier) {
		System.out.println(supplier.get());
	}
}
@AllArgsConstructor
@Getter
@Setter
class Person{
	private Integer no;
	private String name;
	
	public void toObjString() {
		System.out.println("Person : "+no+", "+name);
	}
}
class HelloTo{
	public static String hello(String name) {
		return "Hello~~"+name;
	}
}
class Writer{
	public static void doWriter(Object msg) {
		System.out.println(msg);
	}
}
/*
 - static 메서드 참조
 - 특정 객체의 인스턴스 메서드 참조
 - 특정 타입의 임의 객체에 대한 인스턴스 메서드 참조
 - 생성자 참조 
*/