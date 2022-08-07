import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        String[] StringNum = new String[numbers.length];
		String answer = "";
		
		for (int i = 0; i < numbers.length; i++) {
			StringNum[i] = Integer.toString(numbers[i]);
		}

		Arrays.sort(StringNum, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				String o1Plus = o1 + o1 + o2;
				String o2Plus = o2 + o2 + o1;
				return o2Plus.compareTo(o1Plus);
			}
		});
        
        if(StringNum[0].equals("0")) return "0";
        
        for (String s : StringNum) {
				answer += s;
			}
        
        return answer;
    }
}