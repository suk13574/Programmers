import java.util.LinkedList;
import java.util.Queue;
class Solution {
    static boolean[] check;

	static void bfs(int start, int[][] computers) {
		boolean[] visit = new boolean[computers.length];
		Queue<Integer> q = new LinkedList<>();
		q.add(start);

		while (!q.isEmpty()) {
			int computer = q.poll();
			visit[computer] = true;
			check[computer] = true;
			for (int i = 0; i < computers.length; i++) {
				if (computers[computer][i] == 1 && !visit[i]) {
					q.add(i);
				}
			}
		}
	}
    public int solution(int n, int[][] computers) {
        check = new boolean[n];
		int answer = 0;
        
		for (int i = 0; i < n; i++) {
			if (!check[i]) {
				bfs(i, computers);
				answer++;
			}
		}
        return answer;
    }
}
