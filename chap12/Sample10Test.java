package chap12;

import java.util.Scanner;
import java.util.TreeSet;

public class Sample10Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("몇 개의 예상번호를 출력하시겠습니까.");
		int N = sc.nextInt();
		sc.close();
		for(int i=0; i<N; i++) {
			var list = new TreeSet<Integer>();
			
			//7개의 숫자 발생
			for(int j=0; j<7; j++) {
				int num = (int)(Math.random()*45)+1;
//				System.out.printf("%4d ", num);
				
				// 이미 값이 있는지 확인, 중복되지 않은 수는 list에 추가
			if(!list.contains(num)) { // 중복이 아니면 
				
				if(j==6) { // 마지막 숫자 : 보너스 번호 출력
					for(int no : list) {
						System.out.printf("%3d ", no);					
					}
					System.out.println("+ 보너스"+num);
				}else { // 중복이 아니면서 마지막 숫자가 아닌경우 
					list.add(num);
				}
			}
			else { // 중복이 이면 
			j--; // 중복된 값이 있으면 다시 숫자를 받는
			}
			}
		System.out.println();
//		System.out.println(list.toString());
		
		}
	}
}