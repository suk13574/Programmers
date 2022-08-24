class Solution {
    public int solution(String begin, String target, String[] words) {
        visit = new boolean[words.length];
		permutation(begin, target, words, 0);
		System.out.println((answer == 51)?0:answer);
        return (answer == 51) ? 0 : answer;
    }
    static boolean[] visit;
	static int answer = 51;
    
    //순열
	static void permutation(String begin, String target, String[] words, int count) {
		if (begin.equals(target)) {
			answer = Math.min(answer, count);
			return;
		}

		for (int i = 0; i < words.length; i++) {
			if(!visit[i] && change(begin, words[i])) {
				visit[i] = true;
				permutation(words[i], target, words, count + 1);
				visit[i] = false;
			}
		}
	}

	static boolean change(String begin, String word) {
		int check = 0;
		for (int i = 0; i < begin.length(); i++)  
			if(begin.charAt(i) != word.charAt(i)) check++;
		if(check == 1) return true;
		return false;
		
	}
}