import java.util.*;
class Solution {
    public String solution(String number, int k) {
        		Stack<String> answer = new Stack<>();
		
 		String[] num = number.split("");
		for(String n : num) {
			if(answer.isEmpty()) {
				answer.push(n);
				continue;
			}
			int size = answer.size();
			for(int i = 0 ; i < size;i++) {
				if(Integer.parseInt(answer.peek()) < Integer.parseInt(n) && k > 0) {
					answer.pop();
					k--;
				}
				else break;
			}
			answer.push(n);
			
		}
        while(k != 0) {
			answer.pop();
			k--;
		}
        
		String StrAnswer="";
		int size = answer.size();
		for(int i = 0 ; i < size; i++) {
			StrAnswer += answer.elementAt(i);
		}
        return StrAnswer;
    }
}