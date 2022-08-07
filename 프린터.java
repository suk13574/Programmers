import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		for (int i : priorities) {
			pq.offer(i);
		}

		int check = 0;
		while (!pq.isEmpty()) {
			for (int i = 0; i < priorities.length; i++) {
				if (priorities[i] == pq.peek()) {
					if (i == location) {
						answer++;
						System.out.println(answer);
						check = 1;
						break;
					}
					pq.poll();
					answer++;
				}
			}
			if (check == 1)
				break;
		}
        return answer;
    }
}