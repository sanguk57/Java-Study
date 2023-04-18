package chap12;

import java.util.function.BiConsumer;
import java.util.function.Consumer;


public class Sample10Constructors2 {

	public static void main(String[] args) {
		BiConsumer<Integer, Integer> plus1 = (a,b)->new Plus(a, b);
		plus1.accept(10, 100);
		
		BiConsumer<Integer, Integer> plus2 = Plus::new;
		plus2.accept(10, 100);
		
		Consumer<Integer> fn = (a) -> {
			
			for(int i=1; i<=9;i++) {
				System.out.printf("%d * %d = %d\n",a,i,a*i);
			}
		};
		for(int i=2; i<=9; i++) {
		fn.accept(i);
		System.out.println("-------------");
		}
		
		Runnable fn1 = guguDan1::new;
		fn1.run();	
		Runnable fn2 = () -> new guguDan1();
		fn2.run();
	}

}

class Plus {
	public Plus(int a, int b) {
		System.out.printf("%d + %d = %d\n", a, b, a+b );
	}
}
class guguDan1{
	public guguDan1() {
		for(int i=1; i<=9;i++) {
			for(int j=2;j<=9; j++) {
				System.out.printf("%d * %d = %d\n",i,j,i*j);
			}
			System.out.println("----------");
		}
	}
}



/* 매개변수 받아서 구구단을 출력하는 람다식을 작성하고
매개변수로 2부터 9까지 넣어서 구구단을 모두 출력하시오
*/