import java.util.LinkedList;
import java.util.Queue;
class Solution {
	public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
		int maxX = 0;
		int maxY = 0;
		for (int i = 0; i < rectangle.length; i++) {
			for (int j = 0; j < rectangle[i].length; j++) {
				rectangle[i][j] *= 2;
				if (j % 2 == 0) maxX = Math.max(maxX, rectangle[i][j]);
				else maxY = Math.max(maxY, rectangle[i][j]);
			}
		}

		int[][] graph = new int[104][104];

		// 네모 변 1로 채우기
		for (int[] i : rectangle) {
			// 좌표 기입
			for (int x = i[0]; x <= i[2]; x++) {
				graph[x][i[1]] = 1;
				graph[x][i[3]] = 1;
			}
			for (int y = i[1]; y <= i[3]; y++) {
				graph[i[0]][y] = 1;
				graph[i[2]][y] = 1;
			}
		}
		
		// 네모 안 0으로 채우기
		for (int[] i : rectangle) {
			for (int x = i[0] + 1; x < i[2]; x++) {
				for (int y = i[1] + 1; y < i[3]; y++) graph[x][y] = 0;
			}
		}

		return (bfs(graph, new int[] { characterX * 2, characterY * 2 }, new int[] { itemX * 2, itemY * 2}) / 2);

	}

	static int bfs(int[][] graph, int[] start, int[] item) {
		int[][] moves = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		boolean[][] visit = new boolean[graph.length][graph[0].length];

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { start[0], start[1], 0 });

		int[] temp = new int[3];
		while (!q.isEmpty()) {
			temp = q.poll();
			if (visit[temp[0]][temp[1]])
				continue;

			if (item[0] == temp[0] && item[1] == temp[1])
				break;
			
			visit[temp[0]][temp[1]] = true;

			for (int[] move : moves) {
				int nextX = temp[0] + move[0];
				int nextY = temp[1] + move[1];
				if (graph[nextX][nextY] == 1 && !visit[nextX][nextY])
					q.add(new int[] { nextX, nextY, temp[2] + 1 });
			}
		}
		return temp[2];
	}
}
