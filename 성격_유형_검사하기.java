import java.util.HashMap;

class Solution {
	public String solution(String[] survey, int[] choices) {
		String[][] pairs = new String[][] { { "R", "T" }, { "C", "F" }, { "J", "M" }, { "A", "N" } };
		HashMap<String, Integer> map = new HashMap<>();

		String str = "";
		for (int i = 0; i < survey.length; i++) {
			int score = choices[i];
			if (score == 4) continue;
			else if (score < 4) {
				str = survey[i].substring(0, 1);
				score = -(score - 4);
			} else {
				str = survey[i].substring(1);
				score -= 4;
			}

			map.put(str, map.getOrDefault(str, 0) + score);
		}

		String answer = "";
		for (String[] pair : pairs) {
			int first = map.getOrDefault(pair[0], 0);
			int second = map.getOrDefault(pair[1], 0);
			if (first < second) answer += pair[1];
			else answer += pair[0];
		}
		return answer;
	}
}