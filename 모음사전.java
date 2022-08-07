class Solution {
    String[] words = new String[] {
			"A", "E", "I", "O", "U"	
		};
    boolean[][] visit = new boolean[5][5];
	int count = 0;
	int answer = 0;
	boolean check = false;
    
    public int solution(String word) {
        dfs("", word);
        return answer;
    }

    
    public void dfs(String str, String word) {
		if(str.length() == 5 || str.equals(word)) {
			if(str.equals(word)) {
				answer = count;
			}
			return;
		}
		for(int i = 0 ; i < 5; i++) {
			count++;
			dfs(str+words[i], word);
		}
	}
}