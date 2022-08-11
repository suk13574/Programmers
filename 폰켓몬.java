import java.util.HashSet;
class Solution {
    public int solution(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		
		for(int num : nums) set.add(num);
		
		if (set.size() >= nums.length / 2) return nums.length / 2;
		else return set.size();
    }
}