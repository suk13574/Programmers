class Solution {
    public int solution(int[] money) {
        int n = money.length;
		int[] stealFirst = new int[n];
		int[] notStealFirst = new int[n];
		
		stealFirst[0] = money[0];
		stealFirst[1] = Math.max(money[0], money[1]);
		
		notStealFirst[0] = 0;
		notStealFirst[1] = money[1];
		
		for (int i = 2; i < n; i++) {
			stealFirst[i] = Math.max(money[i] + stealFirst[i - 2], stealFirst[i - 1]);
			notStealFirst[i] = Math.max(money[i] + notStealFirst[i - 2], notStealFirst[i - 1]);
		}
		
		return Math.max(stealFirst[n - 2], notStealFirst[n - 1]);

    }
}