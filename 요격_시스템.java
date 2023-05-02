import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        //끝나는 지점에 대해 오름차순 정렬
        Arrays.sort(targets, (o1, o2) -> {
            if(o1[1] == o2[1]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });
        
        int answer = 0;
        
        int now = targets[0][1];
        answer++;
        
        for(int[] target : targets){
            if(target[0] >= now){
                answer++;
                now = target[1];
            }
        }
        
        return answer;
    }
}