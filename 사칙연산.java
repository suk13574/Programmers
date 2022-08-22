import java.util.Arrays;
class Solution {
    public int solution(String arr[]) {
        int operandCount = arr.length/2 + 1;
		int[][] max_dp = new int[operandCount][operandCount];
		int[][] min_dp = new int[operandCount][operandCount];
		//dp초기화
		for (int i = 0; i < operandCount; i++) {
			Arrays.fill(max_dp[i], Integer.MIN_VALUE);
			Arrays.fill(min_dp[i], Integer.MAX_VALUE);
		}
		//대각선엔 내 숫자 넣기
		for (int i = 0; i < arr.length; i = i + 2) {
			max_dp[i/2][i/2] = Integer.parseInt(arr[i]);
			min_dp[i/2][i/2] = Integer.parseInt(arr[i]);
		} 
		
		for (int i = operandCount - 1; i >= 0; i--) {
			for (int j = i + 1; j < operandCount; j++) {
				for (int k = i; k < j; k++) {
					int symbol = k * 2 + 1;
					if (arr[symbol].equals("+")) {
						max_dp[i][j] = Math.max(max_dp[i][j], max_dp[i][k] + max_dp[k + 1][j]);
						min_dp[i][j] = Math.min(min_dp[i][j], min_dp[i][k] + min_dp[k + 1][j]);
					} 
					else {
						max_dp[i][j] = Math.max(max_dp[i][j], max_dp[i][k] - min_dp[k + 1][j]);
						min_dp[i][j] = Math.min(min_dp[i][j], min_dp[i][k] - min_dp[k + 1][j]);
					}
				}
			}
		};
        return max_dp[0][operandCount-1];
    }
}