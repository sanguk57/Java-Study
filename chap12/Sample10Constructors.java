package chap12;

import java.util.function.Supplier;

import lombok.Getter;

public class Sample10Constructors {

	public static void main(String[] args) {
		// 생성자 참조, (Object name)::new
		// 1. new Object()
		// 2. () -> new Object()
		// 3. Object::new -> 생성자 참조 
		
		Supplier<Name> fn1 = () -> new Name(); // 람다식 맴버변수 초기화 가능 
		System.out.println(fn1.get());
		
		Supplier<Name> fn2 = Name::new; // 생성자 참조 기본 생성자만 초기화 안됨  
		System.out.println(fn2.get());
		
		System.out.println(fn1()); // static메서드로 
		
		Supplier<String> supplier = () -> "문자열 반환";
		System.out.println(supplier.get());

	}
	private static Name fn1() { //이런식도 가능 
		return new Name(); // 맴버변수 초기화 가능 
	}
}
	
@Getter
class Name{
	private String name;
	public Name() {
		this.name = "홍길동";
	}
}
