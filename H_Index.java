import java.util.Collections;
import java.util.PriorityQueue;
class Solution {
    public int solution(int[] citations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i : citations) {
			pq.offer(i);
		}

		int h_idx = 0;
		
		while(!pq.isEmpty() && h_idx < pq.poll()) {
			h_idx++;
		}
        
        return h_idx;
    }
}