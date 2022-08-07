class Solution {
    static int answer;
	static boolean[] visit;
    public int solution(int[] numbers, int target) {
        visit = new boolean[numbers.length];
		answer = 0;
		int num = 0;
		for (int i : numbers)
			num += i;
		for (int i = 0; i < numbers.length; i++) {
			combination(numbers, target, num, 0, i + 1);
		}
        return answer;
    }
    public static void combination(int[] numbers, int target, int num, int start, int r) {
		if (r == 0) {
			if (num == target)
				answer++;
			return;
		}
		for (int i = start; i < numbers.length; i++) {
			visit[i] = true;
			combination(numbers, target, num - numbers[i] * 2, i + 1, r - 1);
			visit[i] = false;
		}
	}
}