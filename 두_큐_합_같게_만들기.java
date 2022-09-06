import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public int solution(int[] queue1, int[] queue2) {
		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();

		long sum1 = 0;
		long sum2 = 0;
		for (int i = 0; i < queue1.length; i++) {
			sum1 += queue1[i];
			sum2 += queue2[i];
			q1.add(queue1[i]);
			q2.add(queue2[i]);
		}

		int answer = 0;
		int count = queue1.length * 3;
		for (int i = 0; i < count; i++) {
			if (sum1 == sum2) break;

			if (sum1 < sum2) {
				int temp = q2.poll();
				q1.add(temp);
				sum1 += temp;
				sum2 -= temp;
			} else {
				int temp = q1.poll();
				q2.add(temp);
				sum1 -= temp;
				sum2 += temp;
			}
			answer++;
		}

		return ((sum1 == sum2) ? answer : -1);
	}

}