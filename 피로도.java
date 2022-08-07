class Solution {
    int answer = 0;
	boolean[] visit;
    
    public int solution(int k, int[][] dungeons) {
        visit = new boolean[dungeons.length];
		dfs(0, k, dungeons);
        return answer;
    }
    
    public void dfs(int visitDungeon, int k, int[][] dungeons) {
		for(int i = 0 ; i < dungeons.length;i++) {
			if(!visit[i] && dungeons[i][0] <= k) {
				visit[i] = true;
				dfs(visitDungeon + 1,  k - dungeons[i][1], dungeons);
				visit[i] = false;
			}
			answer = Math.max(answer, visitDungeon);
		}
	}
}