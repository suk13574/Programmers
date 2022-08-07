class Solution {
    public int solution(String name) {
      int answer = 0;
      String[] word = name.split("");
      int move = name.length() - 1; //오른쪽으로 쭉 이동한 횟수
      
      //상하 움직인 횟수
      for(int i = 0 ; i < name.length();i++) {
         int gap = word[i].compareTo("A");
         if(gap > 13) gap = 26 - gap;
         answer += gap;
         
         int nextIdx = i + 1;
         //A인덱스 체크
         if (nextIdx < name.length() && word[nextIdx].equals("A")) {
			int move1, move2;

			while (nextIdx < name.length() && word[nextIdx].equals("A")) nextIdx++;

			move1 = i * 2 + name.length() - nextIdx; // 오른쪽으로 갔다 왼쪽으로
			move2 = i + (name.length() - nextIdx) * 2; // 왼쪽으로 갔다 오른쪽으로
			move = Math.min(move, Math.min(move1, move2));
		}
      }
        return answer + move;
    }
}