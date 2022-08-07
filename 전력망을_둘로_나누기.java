import java.util.*;
class Solution {
    public static List<Integer>[] list;
    
    public int solution(int n, int[][] wires) {
        int answer = 100;
		list = new List[n+1];
		for(int i = 0 ; i <= n ; i++) {
			list[i] = new ArrayList<>();
		}
		for(int[] wire : wires) {
			list[wire[0]].add(wire[1]);
			list[wire[1]].add(wire[0]);
		}
		
		for(int[] wire : wires) {
			int n1 = bfs(wire[0], wire[1], n);
			int n2 = bfs(wire[1], wire[0], n);
			
			answer = Math.min(answer, Math.abs(n1-n2));
		}
        return answer;
    }
    
    public static int bfs(int v1, int v2, int n) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visit = new boolean[n + 1];
		
		int count = 0;
		
		q.add(v1); //송진탑 넣기
		visit[v1] = true;
		
		while(!q.isEmpty()) {
			int next = q.poll(); //송진탑 하나 뺌
			count++;
			
			for(int nextConnection : list[next]) {
				if(nextConnection != v2 && !visit[nextConnection]) {
					q.add(nextConnection);
					visit[nextConnection] = true;
				}
			}
		}
		return count;
	}
}