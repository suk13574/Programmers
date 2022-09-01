import java.util.Arrays;
class Solution {
	public long solution(int n, int[] times) {
		Arrays.sort(times);
		long answer = 0;

		long min = 1;
		long max = (long)times[times.length - 1] * n;
		long mid;

		while (min <= max) {
			mid = (max + min) / 2;

			long sum = 0;
			for (int i = 0; i < times.length; i++) {
				sum += mid / times[i];
			}

			if (sum >= n) {
				answer = mid;
				max = mid - 1;
			} else {
				min = mid + 1;
			}
		}

		return answer;
	}
}