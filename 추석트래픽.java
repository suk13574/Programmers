import java.time.*;
import java.time.format.DateTimeFormatter;
class Solution {
    public int solution(String[] lines) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
		LocalDateTime[][] time = new LocalDateTime[lines.length][2];
		int count = 0;
		
		float T;
		for (int i = 0; i < lines.length; i++) {
			String StrDateTime = "";
			String[] temp = lines[i].split(" ");
			StrDateTime = StrDateTime + temp[0] + " " + temp[1];
			time[i][1] = LocalDateTime.parse(StrDateTime, formatter); //끝나는 시간 저장
			
			temp[2] = temp[2].substring(0, temp[2].length()-1);
			T = Float.parseFloat(temp[2]);
			T = T * 1000 - 1;
			time[i][0] = time[i][1].minusNanos((long) T * 1000000); //시작 시간 계산하여 저장
		}
		
		LocalDateTime before;
		LocalDateTime after;
		int beforeCount;
		int afterCount;
		
		for (int i = 0; i < lines.length; i++) {
			beforeCount = 0;
			afterCount = 0;
			before = time[i][1].minusNanos(999 * 1000000);
			after = time[i][1].plusNanos(999 * 1000000);
			for(int j = 0 ; j < lines.length; j++) {
				//기준 1초전에 포함되는지
				if(check(before, time[i][1], time[j])) {
					beforeCount++;
				}
				//기준 1초후에 포함되는지
				if(check(time[i][1], after, time[j])) {
					afterCount++;
				}
			}
			count = Math.max(count, Math.max(beforeCount, afterCount));
			
		}
        return count;
    }
    
    public static boolean check(LocalDateTime start, LocalDateTime end, LocalDateTime[] t) {
		//1. 시작 전 작업 끝남
		if(t[1].isBefore(start)) {
			return false;
		}
		//2. 끝나고 작업 시작함
		else if(t[0].isAfter(end)) {
			return false;
		}
		else return true;
	}
}