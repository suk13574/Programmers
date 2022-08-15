import java.util.Arrays;
class Solution {
    static public void union(int[] parent, int x, int y) {
		x = find(parent, x);
		y = find(parent, y);
		
		if(x < y) parent[y] =x;
		else parent[x] = y;
	}

	private static int find(int[] parent, int x) {
		if (parent[x] == x) return x;
		else return find(parent, parent[x]);
	}
	
	public static int kruskal(int[][] costs, int[] parent) {
		int total = 0;
		for(int[] cost : costs) {
			if(find(parent, cost[0]) != find(parent, cost[1])) {
				union(parent, cost[0], cost[1]);
				total += cost[2];
			}
		}
		return total;
	}
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
		
		int[] parent = new int[n+1];
		for (int i = 0; i < parent.length; i++) parent[i] = i;
        return kruskal(costs, parent);
    }
}