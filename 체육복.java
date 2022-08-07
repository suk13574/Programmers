class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] student = new int[n];
        
        for (int i : lost) student[i - 1]--;
		for (int i : reserve) student[i - 1]++;
		
		for(int i : student) {
			System.out.print(i+" ");
		}

		int answer = n;
		for (int i = 0; i < n; i++) {
			if (student[i] < 0) {
				// 1. 체육복 없으면 왼쪽 친구 검사
				if (i != 0 && student[i - 1] == 1) {
					student[i - 1]--;
				}
				// 2. 왼쪽 친구 없으면 오른쪽 친구 검사
				else if (i != n - 1 && student[i + 1] == 1) {
					student[i + 1]--;
				} else
					answer--;
			}
		}
        return answer;
    }
}