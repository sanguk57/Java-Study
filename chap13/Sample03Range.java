package chap13;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Sample03Range {

	public static void main(String[] args) {
		// range(), rangeClose()
		IntStream.rangeClosed(1, 10).forEach(System.out::println);
		IntStream.rangeClosed(10, 20).forEach(x->System.out.println(x));
		System.out.println("------");
	
		IntStream.rangeClosed(1, 10).forEach(x->{ // rangeClose():1~10까
			if(x%3==0) 
				System.out.println(x+" 는 3의 배수");
			else 
				System.out.println(x+" 는 3의 배수가 아님");
		});
		
		IntStream.range(1, 10).forEach(System.out::println); //range():1~9까지 
	
		List<Board> boardlist = new ArrayList<Board>();
		IntStream.rangeClosed(1, 100).forEach(i->{
			boardlist.add(new Board(i, "title_"+i, "user_"+i, LocalDateTime.now()));
		});
//		boardlist.stream().forEach(System.out::println);
		boardlist.stream().forEach(board->System.out.println(board));
	}

}
@AllArgsConstructor
@Data
class Board{
	int no;
	String title;
	String nser;
	LocalDateTime createdate;
}