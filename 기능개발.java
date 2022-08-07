import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        		Queue<Integer> queue = new LinkedList<>();
		List<Integer> answerList = new ArrayList<>();
		for (int i = 0; i < progresses.length; i++) {
			int time = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
			queue.add(time);
		}
		while (!queue.isEmpty()) {
			int finish = queue.poll();
			int count = 1;
			
			while (!queue.isEmpty() && (finish >= queue.peek())) {
				queue.poll();
				count++;
			}
			answerList.add(count);
		}
		
		int[] answer = new int[answerList.size()];
		int index= 0;
		for(int i : answerList) {
			answer[index++] = i;
        }
        return answer;
    }
}