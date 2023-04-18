package chap12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MathTest {
	public static void main(String[] args) {
		List<Answer> list = new ArrayList<>();
		Answer answer1 = new Answer(1, 5);
		Answer answer2 = new Answer(5, 5);
		Answer answer3 = new Answer(2, 4);
	
		list.add(answer1);
		list.add(answer2);
		list.add(answer3);
		Test1.Test1(list);
		System.out.println(Test1.Test1(list));
	}
	 static class Test1{

		public static String Test1(List<Answer> list){

		int[][] patterns = {{1, 1, 1, 1, 1}, {3, 3, 3, 3, 3}, {5, 5, 5, 5, 5}};

		int[] scores = {0, 0, 0}; // a, b, c 각각의 점수

			int pn = 0;

			for(Answer ans : list){

			for(int i = 0 ; i<3; i++){

			if(ans.getAnswer() == patterns[i][pn % patterns[i].length]){

			scores[i] += ans.getScore(); // 찍은 번호와 index위치가 정답과 일치하면 점수 증가

			}

			pn++;

			}

			}

		int maxScore = Math.max(scores[0], Math.max(scores[1], scores[2])); // a, b, c중 가장 큰 점수

		StringBuilder result = new StringBuilder();

		for (int i = 0; i < 3; i++) {

		if (scores[i] == maxScore) {

		if (result.length() > 0) {

		result.append(", ");

		}

		if (i == 0) { result.append("a");

		}

		else if (i == 1) { result.append("b");

		}

		else { result.append("c");

		}

		result.append(" : ").append(maxScore);

		}

		}

		return result.toString();

		}

		}

		static class Answer {

		private int answer; // 답

		private int score; // 점수

		public Answer(int answer, int score) {

		this.answer = answer;

		this.score = score;

		}

		public int getAnswer() {

		return answer;

		}

		public int getScore() {

		return score;

		}

		}


}
