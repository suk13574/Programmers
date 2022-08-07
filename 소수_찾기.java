import java.util.*;
class Solution {
    boolean[] visit;
	int answer = 0;
    public int solution(String numbers) {
        String[] number = numbers.split("");
		HashSet<Integer> set = new HashSet<>();
		visit = new boolean[number.length];
		dfs("",number,set);
        return answer;
    }
    //DFS로 문자열 모두 조합
    public void dfs(String str, String[] number, HashSet<Integer> set) {
		for (int i = 0; i < number.length; i++) {
			if(!visit[i]) {
				visit[i] = true;
				str += number[i];
				if(!set.contains(Integer.parseInt(str))) {
					set.add(Integer.parseInt(str));
					if(primeTest(Integer.parseInt(str)))
						answer++;
				}
				dfs(str, number, set);
				visit[i] = false;
				str = str.substring(0, str.length()-1);
			}
		}
	}
    
    //소수찾기
    public boolean primeTest(int num) {
		double k = Math.sqrt(num);
		int d = 3;
		while (true) {
			if (num == 1)
				return false;
			else if (num == 2 || num == 3)
				return true;
			else if ((num % 2) == 0)
				return false;
			else if (num % d == 0)
				return false;
			else {
				d += 2;
				if (d > (int) k)
					return true;
			}
		}
	}
    
}