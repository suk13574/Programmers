import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
		ArrayList<Integer> list = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		for(int i : arr) {
			if(!stack.isEmpty() && stack.peek() == i) continue;
			stack.push(i);
		}

		int[] answer = new int[stack.size()];
		for (int i = stack.size() - 1; i >= 0; i--) {
			answer[i] = stack.pop();
		}
        return answer;
    }
}