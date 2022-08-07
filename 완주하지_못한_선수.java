import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap map = new HashMap();
        
        for(String s : participant){
            if(map.containsKey(s)){
                int count = (int)map.get(s);
                map.put(s, count + 1);
            } else{
                map.put(s, 1);
            }
        }
        
        for(String s : completion){
            if(map.containsKey(s)){
                int count = (int)map.get(s);
                count--;
                if(count < 1){
                    map.remove(s);
                }
                else{
                    map.put(s, count);
                }
            }
        }
        
        Iterator iter = map.entrySet().iterator();
        Map.Entry entry = (Map.Entry)iter.next();
        System.out.println(entry.getKey()+" "+entry.getValue());

        
        String answer = (String)entry.getKey();
        
        return answer;
    }
}