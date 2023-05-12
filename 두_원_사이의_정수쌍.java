class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;

        // x좌표 1부터 r2까지 일떄 원 사이에 있는 y 값 체크
        for(int i = 1; i <= r2; i++){
            // 작은 원 반지름보다 위에 있는 y 좌표
            long smallY = (long) Math.ceil(Math.sqrt(Math.pow(r1, 2) - Math.pow(i, 2)));

            // 큰 원 반지름보다 아래에 있는 y 좌표
            long bigY = (long) Math.floor(Math.sqrt(Math.pow(r2, 2) - Math.pow(i, 2)));

            // 큰 원, 작은 원 사이에 있는 y 좌표
            answer += bigY - smallY + 1;
        }

        return answer * 4;
    }
}