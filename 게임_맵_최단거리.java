import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int solution(int[][] maps) {
        visit = new boolean[maps.length][maps[0].length];
        return bfs(maps, 0, 0);
    }
    
    static boolean[][] visit;
	static Queue<Node> q;
	
	public static int bfs(int[][] map, int i, int j) {
		int[] dx = {0 , 0, 1, -1};
		int[] dy = {1, -1, 0, 0};
		
		q = new LinkedList<>();
		q.add(new Node(i, j, 1));
		visit[i][j] = true;

		while (!q.isEmpty()) {
			Node node = q.poll();
			if (node.x == map.length - 1 && node.y == map[0].length - 1)
				return node.depth;

			for (int k = 0; k < 4; k++) {
				int x = node.x + dx[k];
				int y = node.y + dy[k];
				if (x >= 0 && y >= 0 && x < map.length && y < map[0].length) {
					if (!visit[x][y] && map[x][y] == 1) {
						visit[x][y] = true;
						q.add(new Node(x, y, node.depth + 1));
					}
				}
			}
		}
		return -1;
	}
}

class Node {
	int x;
	int y;
	int depth;
	
	public Node(int x, int y, int depth) {
		this.x = x;
		this.y = y;
		this.depth = depth;
	}
}