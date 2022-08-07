class Solution {
    public int solution(int[][] sizes) {
        int MaxWide = 0; 
		int MaxHeight = 0;
		for(int i = 0 ; i < sizes.length; i++) {
			int wide = Math.max(sizes[i][0], sizes[i][1]);
			int height = Math.min(sizes[i][0], sizes[i][1]);
			MaxWide = Math.max(MaxWide, wide);
			MaxHeight = Math.max(MaxHeight, height);
		}
		
		int answer = MaxWide*MaxHeight;
        return answer;
    }
}