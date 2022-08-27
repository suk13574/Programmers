import java.util.ArrayList;
import java.util.Collections;

class Solution {
	static boolean[] visit;
	static ArrayList<String> routes;

	public String[] solution(String[][] tickets) {
		routes = new ArrayList<>();
		visit = new boolean[tickets.length];
		
		dfs(tickets, "ICN", "ICN", 0);
		Collections.sort(routes);
		String[] answer = routes.get(0).split(" ");
		return answer;
	}

	static void dfs(String[][] tickets, String route, String start, int count) {
		if (count == tickets.length) {
			routes.add(route);
		}

		for (int i = 0; i < tickets.length; i++) {
			if (start.equals(tickets[i][0]) && !visit[i]) {
				visit[i] = true;
				dfs(tickets, route + " " + tickets[i][1], tickets[i][1], count + 1);
				visit[i] = false;
			}
		}
	}
}
