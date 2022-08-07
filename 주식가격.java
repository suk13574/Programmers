import java.util.Stack;
class Solution {
    public int[] solution(int[] prices) {
        	Stack<Integer> stack = new Stack<>();
		int[] answer = new int[prices.length];

		for (int i = 0; i < prices.length; i++) {
			while (!stack.empty() && (prices[i] < prices[stack.peek()])) {
				answer[stack.peek()] = i - stack.peek();
				stack.pop();
			}
			stack.push(i);
		}
		
		while(!stack.empty()) {
			answer[stack.peek()] = prices.length - stack.peek() - 1;
			stack.pop();
		}
        return answer;
    }
}