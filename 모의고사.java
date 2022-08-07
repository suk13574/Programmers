import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] first = new int[] { 1, 2, 3, 4, 5 };
		int[] second = new int[] { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] third = new int[] { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
		int[][] people = new int[][] { first, second, third };
		int[] PeopleScore = new int[3];
		List<Integer> answer = new ArrayList<>();
		
		int score;
		int idx = 0;
		for (int[] person : people) {
			score = 0;
			for (int i = 0; i < answers.length;i++) {
				if(answers[i] == person[i%person.length]) score++;
			}
			PeopleScore[idx++] = score;
		}
		
		int maxScore = -1;
		for (int i = 0; i< PeopleScore.length;i++) {
			if (maxScore <= PeopleScore[i]) {
				if(maxScore == PeopleScore[i]) {
					answer.add(i+1);
					continue;
				}
				maxScore = PeopleScore[i];
				answer.clear();
				answer.add(i+1);
			}
		}
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}