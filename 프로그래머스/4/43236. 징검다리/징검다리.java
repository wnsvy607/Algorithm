import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int left = 1; int right = distance; int mid = 0;
        
        while(left <= right) {
            int cnt = 0; int prev = 0;
            mid = (left + right) / 2;
            
            for(int rock : rocks) {
                if(rock - prev < mid)
                    cnt++;
                else
                    prev = rock;
            }
            
            if(distance - prev < mid)
                cnt++;
            
            if(cnt > n) right = mid - 1;
            else left = mid + 1;
        }
        
        
        return right;
    }
}