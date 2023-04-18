package chap12;

import oracle.net.aso.j;

public class Sample01FunctionInterface {

	public static void main(String[] args) {
		//함수형 인터페이스 : 단 한개의 추상매서드를 가지고 있는 인터페이스 
		//@FunctionalInterface 어노테이션 
		myPrn();
		
		//인자가 없고 반환값이 없는 형식 
		Sample01Fun01 fn = () -> System.out.println("함수형인터페이스 본체");
		fn.test();
		
		Sample01Fun01 guguDan = () -> {
			for(int i=2 ;i<=9; i++) {
				for(int j=1; j<=9; j++) {
					System.out.println(i+" * "+j+" = "+i*j);
				}
			}
		}; 
		guguDan.test();
		
		//인자가 있고 반화값이 없는 형식 
		Sample01Fun02 fn2 = str -> System.out.println("인자가 있는 함수형인터페이스 본체 "+str);
		fn2.test("홍길동");
		
		Sample01Fun03 fn3 = (str, age) -> "이름 : "+str+", 나이 : "+age;
		System.out.println(fn3.test("홍길동", 19));
	
		Sample01Fun04 fn4 = (t) -> {
			String str = "";
			for(int i=0; i<t; i++) {
				str += "홍길동\n";
			}
			return str;
		};
		System.out.println(fn4.test(5));
	}
	public static void myPrn() {
		System.out.println("일반 함수 수행");
	}
	
	@FunctionalInterface
	interface Sample01Fun01{
		//단 하나의 추상메서드만 가질수 있음 
		public void test();
	}
	@FunctionalInterface
	interface Sample01Fun02{
		public void test(String name);
	}
	@FunctionalInterface
	interface Sample01Fun03{
		public String test(String name, int age);
	}
	@FunctionalInterface
	interface Sample01Fun04{
		public String test(int times);
	}
	
}
/* 람다식(Lambda expression)
 * 
 * 익명 내부클래스보다 간결
 * 스트림(stream)과 활
 * jdk1.8
 * 
 * 함수형 인터페이스
 * 람다식
 * 메서드 참조 
 */
 
