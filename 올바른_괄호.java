import java.util.Stack;
class Solution {
    boolean solution(String s) {
       Stack<String> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			String str = s.substring(i, i + 1);
			if(str.equals("(")) {
				stack.push(str);
			}
			else {
				if(stack.isEmpty()) return false;
				stack.pop();
			}
		}
        
        if(stack.isEmpty()) return true;
        else return false;
    }
}