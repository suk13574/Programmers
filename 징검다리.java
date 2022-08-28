import java.util.Arrays;
class Solution {
	public int solution(int distance, int[] rocks, int n) {
		int answer = 0;
		Arrays.sort(rocks);

		int left = 1;
		int right = distance;
		int mid;

		while (left <= right) {
			mid = (left + right) / 2;

			int outRock = 0;
			int start = 0;
			for (int i = 0; i < rocks.length; i++) {
				if ((rocks[i] - start) < mid)
					outRock++;
				else
					start = rocks[i];
			}
			if ((distance - start) < mid) outRock++;

			if (outRock > n) right = mid - 1;
			else {
				answer = Math.max(answer, mid);
				left = mid + 1;
			}
		}

		return answer;
	}
}