import java.util.Arrays;
class Solution {
    public int solution(int[][] routes) {
	Arrays.sort(routes, (o1, o2) -> o1[0] - o2[0]);
		
	int spot = routes[0][0]; //카메라 설치 지점
	int minOut = routes[0][1]; 
	int answer = 1;
	
	 for(int i = 1 ; i < routes.length;i++) {
		 if(minOut >= routes[i][0]) {
			 spot = minOut;
			 minOut = Math.min(minOut, routes[i][1]);
		 }
		 else {
			 spot = routes[i][0];
			 minOut = routes[i][1];
			 answer++;
         }
     }
     return answer;
    }
}