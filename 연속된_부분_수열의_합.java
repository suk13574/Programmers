class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {1000001, 3000001};
        
        int left = 0;
        int right = 0;
        int sum = 0;
        
        for(;right < sequence.length; right++) {
            sum += sequence[right];
            while(sum >= k){
                if(sum == k){
                    if((answer[1] - answer[0]) > right - left){
                        answer[0] = left;
                        answer[1] = right;
                    }
                }
                if(left == right) break;
                sum -= sequence[left];
                left++;
            }
        }
        
        
        return answer;
    }
}