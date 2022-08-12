import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> totalPlay = new HashMap<>();
		HashMap<String, PriorityQueue<int[]>> playList= new HashMap<>();
		
		for (int i = 0; i < genres.length; i++) {
			if(!totalPlay.containsKey(genres[i])) {
				playList.put(genres[i], new PriorityQueue<>(new Comparator<>() {
					@Override
					public int compare(int[] o1, int[] o2) {
						return o2[0]-o1[0];
					}
				}));
			}
			
			totalPlay.put(genres[i], totalPlay.getOrDefault(genres[i], 0) + plays[i]);
			playList.get(genres[i]).add(new int[] {plays[i], i});
		}
		
		List<String> keySet = new ArrayList<>(totalPlay.keySet());
		keySet.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return totalPlay.get(o2) - totalPlay.get(o1);
			}
		});
		
		ArrayList<Integer> answer = new ArrayList<>();
		
		PriorityQueue<int[]> list;
		for (String key : keySet) {
			list = playList.get(key);
			answer.add(list.poll()[1]);
			if(!list.isEmpty()) answer.add(list.poll()[1]);
		}
        return answer.stream().mapToInt(i -> i).toArray();
    }
}