package chap12;

import java.util.function.Supplier;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

public class Sample02FunRunnable {

	public static void main(String[] args) {
//		loopFor();
//		loopFor();
//		loopFor();
//		인자없고, 반환값이 있는 함수 function abc(){...... ; return 1000;}
		Supplier<String> s = () -> "Supplier는 매개변수는 없고 반환값이 있는 구조";
		System.out.println( s.get());
	
		System.out.println("----------------");
		
		MessageCenter mc = new MessageCenter("Hello Lambda", 13);
		MessageCenter main = getMsg(()->mc); //인자값을 함수자체로 넘겨 줄수있다. (콜백 함수)
		System.out.println(main);
	}
	// 함수 타입만 (T : 반환타입이 된다.) 정해지면 함수를 인자로 받을 수 있다.
	public static MessageCenter getMsg(Supplier<MessageCenter> mc) { 
		return mc.get(); //mc.toString을 보겠다.
	}
	}

@RequiredArgsConstructor
@ToString
class MessageCenter{
	private final String msg;
	private final int a;
//	@Override
//	public String toString() {
//		return msg+a;
//	}
//	public String getMsg() {
//		return msg;
//	}
//	public int getA() {
//		return a;
//	}
	
		
}

