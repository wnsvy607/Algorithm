import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {

        
        int cnt = 0;
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < people.length; i++) list.add(people[i]);
        
        list.sort((a, b) -> Integer.compare(b, a));
        
        int last = people.length - 1;
        for(int i = 0; i < people.length; i++) {
            if(i > last) break;
            
            if(list.get(i) + list.get(last) <= limit) {
                last--;
            }
            
            cnt++;
            
        }

        
        
        return cnt;
    }
    
}