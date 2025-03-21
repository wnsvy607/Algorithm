import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        
        
        
        
        Set<String> kind = new HashSet<>();
        Map<String, Integer> inter = new HashMap<>();
        
        for(String gem : gems) kind.add(gem);
        
        int left = 0;
        int right = 0;
        
        List<int[]> result = new ArrayList<>();
        
        for(left = 0; left < gems.length; left++) {
            if(left > right) right = left;
            
            while(kind.size() != inter.size() && right < gems.length) {
                inter.put(gems[right], inter.getOrDefault(gems[right], 0) + 1);
                right++;
            }
            
            if(kind.size() != inter.size()) break;
            result.add(new int[]{left + 1, right});
            
            int count = inter.get(gems[left]);
            if(count == 1) inter.remove(gems[left]);
            else inter.put(gems[left], count - 1);
            
        }
        
        
        result.sort((a, b) -> Integer.compare(a[1] - a[0], b[1] - b[0]));
        
        return result.get(0);
    }
}