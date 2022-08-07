class Solution {
    public int[] solution(int brown, int yellow) {
        int n = 1;
		int m;
		int edge;
		
		while(true) {
			if((yellow % n) != 0) {
				n++; continue;
			}
			m = yellow / n;
			edge = (n + 2) * 2 + m * 2;
			if(edge == brown) break;
			else n++;
		}
		
		int[] answer = new int[2];
		if(m>n) {
			answer[0] = m + 2;
			answer[1] = n + 2;
		}
		else {
			answer[0] = n + 2;
			answer[1] = m + 2;
		}
        return answer;
    }
}