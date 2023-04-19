package chap13;

import java.util.Arrays;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Sample02Stream02 {

	public static void main(String[] args) {
		DataObj[] data = {
				new DataObj(1, "길순이"),
				new DataObj(2, "길순이2"),
				new DataObj(3, "길순이3"),
				new DataObj(4, "길순이4")
		};
		// 스트림 생성
		Stream<DataObj> stm = Arrays.stream(data);
		stm.forEach(System.out::println);
//		Stream<DataObj> stm1 = Arrays.stream(data); //일회용 
//		stm1.forEach((x)->System.out.println(x));
		
		// 가변 인자처리 : of()메서드 활용
		// 기본자형[] => 1차원
		// String[] => 2차원 
		String[] str1 = {"홍","길","동"};
		String[] str2 = {"동","순","이"};
		
		Stream<String[]> stm1 = Stream.of(str1, str2); 
		
		System.out.println("***** Stream.of()");
		Stream.of(str1, str2).forEach(x->System.out.println(Arrays.toString(x)));
		
		// flatMap() : 모든 요소를 단일요소로 스트림으로 변환 
		Stream<String> stm2 = stm1.flatMap(Arrays::stream);
		stm2.forEach(System.out::println);
		
		// 비어 있는 스트림(Empty Stream)
		String[] arrStr = null;
//		Stream<String> stm3 = Stream.of(arrStr);
//		stm3.forEach(System.out::println);
		
		// 에러 발생 방지용으로 empty()
		Stream<Object> stm3 = Stream.of((arrStr==null)? Stream.empty() : arrStr);
		
	}

}
@Data
@AllArgsConstructor
class DataObj{
	int no;
	String name;
}