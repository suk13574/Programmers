import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
				Queue<Integer> q = new LinkedList<>();
		
		int time = 0;
		int totaltruck = 0;
		
		for(int truck : truck_weights) {
			while(true) {
				if(q.isEmpty()) {
					q.offer(truck);
					totaltruck += truck;
					time++;
					break;
				}
				else if(q.size() == bridge_length) {
					totaltruck -= q.poll();
				}
				else {
					if (totaltruck + truck > weight) {
						q.offer(0);
						time++;
					}
					else {
						q.offer(truck);
						totaltruck += truck;
						time++;
						break;
					}
				}
			}
		}
        
        return time+bridge_length;
    }
}