import java.util.LinkedList;
import java.util.PriorityQueue;
class Solution {
    public int solution(int[] scoville, int K) {
       PriorityQueue<Integer> pq = new PriorityQueue<>();
		int answer = 0;
		
		for(int i : scoville) {
			pq.offer(i);
		}

		while (pq.peek() < K) {
			if(pq.size() == 1) {
				return -1;
			}

			int first = pq.poll();
			int second = pq.poll();
			pq.offer(first + second * 2);
			answer++;
		}
        return answer;
    }
}