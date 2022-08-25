import java.util.*;

class Solution {
	public int solution(int[][] game_board, int[][] table) {
		int n = game_board.length;
		visit = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (game_board[i][j] == 0 && !visit[i][j]) {
					space.add(bfs(game_board, new int[] { i, j }, 0));
				}
			}
		}

		visit = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (table[i][j] == 1 && !visit[i][j]) {
					puzzles.add(bfs(table, new int[] { i, j }, 1));
				}
			}
		}

		int answer = 0;
		// 퍼즐 빈칸에 모두 꽂아봄
		for (int i = 0; i < puzzles.size(); i++) {
			ArrayList<int[]> puzzle = puzzles.get(i);
			int s_size = space.size();
			for (int j = 0; j < s_size; j++) {
				ArrayList<int[]> board = space.get(j);
				if (board.size() != puzzle.size())
					continue;
				for (int k = 0; k < 4; k++) {
					puzzle = spin(puzzle);
					if (equalPiece(board, puzzle)) {
						answer += board.size();
						space.remove(j);
						break;
					}
				}
				if (s_size > space.size())
					break;
			}
		}

		return answer;
	}

	static boolean[][] visit;
	static LinkedList<ArrayList<int[]>> puzzles = new LinkedList<>();
	static LinkedList<ArrayList<int[]>> space = new LinkedList<>();

	// bfs로 빈 공간 또는 퍼즐 찾기
	static ArrayList<int[]> bfs(int[][] board, int[] start, int check) {
		int[][] move = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		Queue<int[]> q = new LinkedList<>();
		ArrayList<int[]> list = new ArrayList<>();
		int minX = 52;
		int minY = 52;

		q.add(start);

		while (!q.isEmpty()) {
			int[] temp = q.poll();
			if (visit[temp[0]][temp[1]])
				continue;
			visit[temp[0]][temp[1]] = true;
			list.add(temp);
			minX = Math.min(minX, temp[0]);
			minY = Math.min(minY, temp[1]);

			for (int i = 0; i < move.length; i++) {
				int row = temp[0] + move[i][0];
				int col = temp[1] + move[i][1];
				if (row < 0 || col < 0 || row >= board.length || col >= board.length)
					continue;
				if (board[row][col] == check && !visit[row][col])
					q.add(new int[] { row, col });
			}
		}

		// 최소 x, y 좌표가 0, 0 되도록 뺄셈
		for (int i = 0; i < list.size(); i++) {
			list.set(i, new int[] { list.get(i)[0] - minX, list.get(i)[1] - minY });
		}

		list.sort(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0])
					return o1[1] - o2[1];
				return o1[0] - o2[0];
			}
		});
		return list;
	}

	// 90도 회전
	static ArrayList<int[]> spin(ArrayList<int[]> piece) {
		ArrayList<int[]> list = new ArrayList<>();
		int n = piece.size();
		int min = 51;
		// 90도 회전 (x, y) -> (y, -x)
		for (int i = 0; i < n; i++) {
			int[] temp = piece.get(i);
			list.add(new int[] { temp[1], -temp[0] });
			min = Math.min(min, -temp[0]);
		}

		// 90도 회전하고 음수 y 있으면 바꾸기
		if (min < 0) {
			for (int i = 0; i < list.size(); i++) {
				list.set(i, new int[] { list.get(i)[0], list.get(i)[1] - min });
			}
		}

		// 오름차순 정렬
		list.sort(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0])
					return o1[1] - o2[1];
				return o1[0] - o2[0];
			}
		});
		return list;
	}

	static boolean equalPiece(ArrayList<int[]> board, ArrayList<int[]> puzzle) {
		for (int i = 0; i < board.size(); i++)
			if (!Arrays.equals(board.get(i), puzzle.get(i)))
				return false;
		return true;
	}
}