import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
		PriorityQueue<Integer> min = new PriorityQueue<>();
		PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
		
		int num;
		for(String o : operations) {
			String[] oper = o.split(" ");
			
			//삽입연산
			if(oper[0].equals("I")) {
				num = Integer.parseInt(oper[1]);
				min.add(num);
				max.add(num);
			}
			//최댓값 삭제
			else if(oper[1].equals("1")) {
				if(!max.isEmpty()) {
					num = max.poll();
					min.remove(num);
				}
			}
			//최솟값 삭제
			else {
				if(!min.isEmpty()) {
					num = min.poll();
					max.remove(num);
				}
			}
		}
        
        if(max.isEmpty()) return new int[] {0, 0};
        else return new int[] {max.poll(), min.poll()};
    }
}