import java.util.*;
class Solution {
		public String[] solution(String[][] plans) {
			
			// 우선순위큐 - 과제 시간 순으로
			PriorityQueue<Plan> pq = new PriorityQueue<>(
					(o1, o2) -> o1.start - o2.start
					);
			
			for(String[] plan : plans) {
				int start = stringToint(plan[1]);
				pq.add(new Plan(plan[0], start, Integer.parseInt(plan[2])));
//				System.out.println(pq.poll().start);
			}
			
			
			Stack<Plan> stack = new Stack<>(); //못끝낸 과제 스택에 저장
			String[] answer = new String[plans.length];
			int idx = 0;
			int nowTime = 0;
			
			// 새 과제 있거나 못끝낸 과제 있으면 계속 반복문 돌림
			while(!pq.isEmpty() || !stack.isEmpty()) {
				// 새 과제 없으면 못끝낸 과제 마무리
				if(pq.isEmpty()) {
					answer[idx++] = stack.pop().task;
				}
				// 못끝낸 과제 없음 -> 새 과제 시작
				else if(stack.isEmpty()) {
					nowTime = pq.peek().start;
					stack.add(pq.poll());
				}
				// 새 과제, 못끝낸 과제 모두 있음 -> 시간 비교
				else {
					//다음 과제 시간 < 현재 과제 마감 시간 -> 과제 못끝냄
					if(pq.peek().start < nowTime + stack.peek().time) {
						stack.peek().time -= pq.peek().start - nowTime;
						nowTime = pq.peek().start;
						stack.push(pq.poll());
					}
					// 다음 과제 시간 > 현재 과제 마감 시간
					else {
						nowTime += stack.peek().time;
						answer[idx++] = stack.pop().task;
					}
				}			
				
			}

	        return answer;
	    }
		
		// 12:00 시간을 분으로 바꾸는 메서드
		public int stringToint(String start) {
			String[] str = start.split(":");
			int h = Integer.parseInt(str[0]) * 60;
			int m = Integer.parseInt(str[1]);
		
			return h+m;
		}
		
		public static class Plan {
			String task; //과제 이름
			int start; //과제 시작 시간(분)
			int time; //과제 걸리는 시간
			public Plan(String task, int start, int time) {
				this.task = task;
				this.start = start;
				this.time = time;
			}
		}
	}