import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
		List<Integer> list = new ArrayList<>();

		int i, j, k;
		for (int[] command : commands) {
			i = command[0] - 1;
			j = command[1];
			k = command[2] - 1;

			for (int idx = i; idx < j; idx++) {
				pq.offer(array[idx]);
			}
			for (int idx = 0; idx < k; idx++) {
				pq.poll();
			}
			list.add(pq.poll());
			pq.clear();
		}
		
		int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
		
        return answer;
    }
}