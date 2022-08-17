import java.util.*;
class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;
        
        HashSet<Integer>[] numbers = new HashSet[9];
		for (int i = 0; i < numbers.length; i++) numbers[i] = new HashSet<>();

		numbers[1].add(N); // 숫자 1개

		int answer = -1;

		for (int i = 2; i <= 8; i++) {
			
			for (int j = 1; j <= i; j++) {
				Set<Integer> leftSet = numbers[j];
				Set<Integer> rightSet = numbers[i - j];
				
				for(int left : leftSet) {
					for(int right : rightSet) {
						numbers[i].add(left + right);
						numbers[i].add(left - right);
						numbers[i].add(left * right);
						if(left != 0 && right != 0) numbers[i].add(left / right);
						
					}
				}
			}
			
			numbers[i].add(Integer.parseInt(String.valueOf(N).repeat(i)));

			if (numbers[i].contains(number)) {
				answer = i;
				break;
			}
		}
        return answer;
    }
}