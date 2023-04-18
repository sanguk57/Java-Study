package chap12;


public class AntTest {

	public static void main(String[] args) {
		String result = "1";
	    int times = 10; // 반복횟수
	    
	    for(int idx=0; idx<times; idx++) {
	        // String -> char[] 전환, 결과 정보를 char[]로 받음
	        char[] input = result.toCharArray();
	        result = ""; // 결과를 저장할 변수 초기화
	        int count = 1; // 연속된 숫자의 개수를 저장할 변수 초기화
	        
	        // 문자열을 하나씩 탐색
	        for(int i=0; i<input.length; i++) {
	            if(i != input.length-1 && input[i] == input[i+1]) {
	                // 현재 문자와 다음 문자가 같은 경우 개수를 1 증가시킨다.
	                count++;
	            } else {
	                // 현재 문자와 다음 문자가 다른 경우, 현재까지의 결과를 저장한다.
	                result += count + "" + input[i];
	                count = 1; // 개수를 다시 1로 초기화
	            }
	        }
	        
	        System.out.printf("%2d회전:: %s\n", idx+1, result);
	    }
	}
}

	
		
//		String result = "";
//		int times = 10; // 반복횟수
//		
//		for(int idx=0; idx<times; idx++) {
//			if(result.equals("")) { // 값이 없으면 "1"로 초기화 
//				result = "1";
//			}
//			else {
//				// String -> char[] 전환, 결과 정보를 char[]로  받음
//				char[] input =result.toCharArray();
////				처음 if에서 1값을 가지고 돌면 문제가 생긴다. 왜????
//				// 초기값 1을 input에 넣고 result 초기화
//				result ="";
//				// target 초기화는 여기서 한다.
//				String target = "";
//				
//				for(int i=0; i<input.length;i++) {
//					
//					// 첫문자 출력
//					if(target.equals("")) {
//					target = "" + input[i]; // 1 -> "1"
//					result = "1";
////					result += target; // (result)"1" + (target)"1" => "11" 
//					}
//					
//					else if(target.charAt(0)==input[i]){
//						//똑같은 문자가 들어왔을 때 append(추가)
//						target += ""+input[i];
//					}
//					else {
//						//새로운 문자가 들어왔을때 기존에 있던문자열과 연결 해준다 
//						result += "" + target.length() + input[i];
//						// 새로운 문자가 들어왔을때는 한번만 넣어준다.
//						target = "" + input[i];
//					}
//					//마지막 값 넣어준다 
//					if(i==(input.length-1)) {
//						result += "" + target.length();
////						target= "";
//					}
//				}
//            }
//			System.out.printf("%2d회전:: %s\n", idx+1, result);
//		}
//		 result = "";
//		for(int idx=0; idx<times; idx++) {
//			if(result.equals("")) { // 값이 없으면 "1"로 초기화 
//				result = "1";
//			}
//			else {
//				// String -> char[] 전환, 결과 정보를 char[]로  받음
//				char[] input =result.toCharArray();
////				처음 if에서 1값을 가지고 돌면 문제가 생긴다. 왜????
//				// 초기값 1을 input에 넣고 result 초기화
//				result ="";
//				// target 초기화는 여기서 한다.
//				String target = "";
//				
//				for(int i=0; i<input.length;i++) {
//					
//					// 첫문자 출력
//					if(target.equals("")) {
//						target = "" + input[i]; // 1 -> "1"
//						result += target; // (result)"1" + (target)"1" => "11" 
//					}
//					
//					else if(target.charAt(0)==input[i]){
//						//똑같은 문자가 들어왔을 때 append(추가)
//						target += ""+input[i];
//					}
//					else {
//						//새로운 문자가 들어왔을때 기존에 있던문자열과 연결 해준다 
//						result += "" + target.length() + input[i];
//						// 새로운 문자가 들어왔을때는 한번만 넣어준다.
//						target = "" + input[i];
//					}
//					//마지막 값 넣어준다 
//					if(i==(input.length-1)) {
//						result += "" + target.length();
//						target= "";
//					}
//				}
//			}
//			System.out.printf("%2d회전:: %s\n", idx+1, result);
//		}
//	       String antSeq = "1"; // 개미 수열의 초기값은 1
//	        System.out.println(" 1회전 :: 1");
//	        
//	        // 개미 수열 10번째 결과를 만들기 위해 9번의 반복문 실행
//	        for (int i = 2; i <= 10; i++) {
//	            antSeq = nextAntSeq(antSeq); // 다음 개미 수열을 생성
//	            System.out.printf("%2d회전 :: %s\n", i, antSeq);
//	        }
//	    }
//	    
//	    // 주어진 개미 수열에서 다음 개미 수열을 생성하는 메서드
//	    public static String nextAntSeq(String antSeq) {
//	        StringBuilder sb = new StringBuilder(); // 새로운 개미 수열을 생성할 StringBuilder 객체
//	        int count = 1; // 현재 대상 숫자의 연속 개수를 저장하는 변수
//	        char num = antSeq.charAt(0); // 현재 대상 숫자를 저장하는 변수
//	        
//	        // 현재 대상 숫자와 대상 숫자의 연속 개수를 계산하여 StringBuilder에 추가
//	        for (int i = 1; i < antSeq.length(); i++) {
//	            if (antSeq.charAt(i) == num) {
//	                count++;
//	            } else {
//	                sb.append(num).append(count);
//	                num = antSeq.charAt(i);
//	                count = 1;
//	            }
//	        }
//	        
//	        // 마지막 대상 숫자와 대상 숫자의 연속 개수를 StringBuilder에 추가
//	        sb.append(num).append(count);
//	        return sb.toString(); // 새로운 개미 수열을 String으로 반환
//	    }
//	}
//		String num = "12213111213113";
//		int cnt1=0, cnt2=0, cnt3=0; 
//		int index1 = 0, index2 = 0, index3=0;
		
		//문자가 없을때 1  문자길이 만큼 반복 char[]에 하나씩 넣어준다.
		//배열길이를 바꿔가야한다. 
		//배열의 크기가 문자열 반복횟수 
//		for(int i=0; i<2; i++);
//			if(c[0]=='1') {
//				cnt1++;
//				num +=""+c[0]+""+cnt1;
//				System.out.println(num);
//		}
//			cnt1=0;
//		 c = num.toCharArray();
//		System.out.println(Arrays.toString(c));
//		for(int i=0; i<c.length; i++) {
//			if(c[0]==c[i]) {
//				cnt1++;
//				num = ""+c[0]+""+cnt1;
//				index1=i;
//			}
//		}
//		cnt1=0;
//		char[] c = num.toCharArray();
//		 
//		System.out.println(Arrays.toString(c));
//		char[] c = num.toCharArray();
//		
//		for(int i=0; i<c.length; i++) {
//			if(c[0]==c[i]) {
//				cnt1++;
//				num += ""+c[0]+""+cnt1;
//				index1=i;
//			}
//			else if(c[index1+1]==c[i]) {
//				cnt2++;
//				num += ""+c[index1+1]+""+cnt2;
//				index2=i;
//			}else if(c[index2+1]==c[i]) {
//				cnt3++;
//				num += ""+c[index2+1]+""+cnt3;
//				index3=i;
//				
//			}
//		}
//		c = num.toCharArray();
//		System.out.println(Arrays.toString(c));
	


/*
 *로또 예상 번호를 몇 개 생성할지를 키보드로 입력받아서
 *그 수만큼 로또 예측 번호 6개를 정렬한 뒤 출력하고 
 *맨 뒤에 7번째 예측 번호는 '보너스'를 붙여서 다음 실행 결과
 *예와 같이 출력하시오.
 *실행 결과 예)
 *몇 개의 예상번호를 출력하시겠습니까.
 *40, 43, 21, 39, 35, 14 + 보너스 36
 *31, 44, 6, 12, 8, 11 + 보너스 2 
 */


/*문제2)
 * 개미 수열의 법칙을 이용해서 총 10번의 결과 출력
 * 
 * 시작은 1이다
 * 대상숫자외 대상이되는 숫자는 연속으로 몇개인지를 작성
 * ex)
 * 1 -> 11(1 : 1개)
 * 12 -> 1121(1 : 1개, 2 : 1개)
 * 122111(1 : 2개 2 : 1개 1 : 1개)
 * 
 *  실행 결과
 *  1회전 :: 1
 *  2회전 :: 11 
 *  3회전 :: 12
 *  4회전 :: 1121
 *  5회전 :: 122111
 *  6회전 :: 112213
 *  7회전 :: 12221131
 *  8회전 :: 1123123111
 *  9회전 :: 12213111213113
 *  10회전 :: 11221131132111311231 
 */

