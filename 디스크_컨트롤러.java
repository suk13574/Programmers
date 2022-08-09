import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(jobs.length, (a, b) -> a[1]-b[1]);
		Arrays.sort(jobs, ((o1, o2) -> o1[0]-o2[0]));
		
		int time = jobs[0][0]; //첫 작업 시작지점
		int sum = 0;
		int idx = 0;
		for(int i = 0 ; i < jobs.length;i++) {
			//현재 시간 전에 들어온 작업들
			while(idx < jobs.length && time >= jobs[idx][0]) {
				pq.add(jobs[idx++]);
			}
			//큐 비어있고 현재 할 작업 없을 때
			if(idx < jobs.length && pq.isEmpty() && time < jobs[idx][0]) {
				time = jobs[idx][0];
				pq.add(jobs[idx++]);
			}
			
			int[] nowJob = pq.poll();
			sum += (time - nowJob[0]) + nowJob[1];
			time += nowJob[1];
		}
        return sum/jobs.length;
    }
}