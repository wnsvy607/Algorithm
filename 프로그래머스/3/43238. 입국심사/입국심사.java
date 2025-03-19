class Solution {
    public long solution(int n, int[] times) {
        long left = 0; long right = 1_000_000_000L * 1_000_000_000L; long mid = 0;
        long minTime = Long.MAX_VALUE;
        
        while(left <= right) {
            mid = (left + right) / 2;
            
            if(checkPossible(n, times, mid)) {
                minTime = Math.min(minTime, mid);
                right = mid - 1;
            }
            else left = mid + 1;
        }
        
        

        return minTime;
    }
    
    boolean checkPossible(int n, int[] times, long total) {
        long cnt = 0;
        for(int time : times) {
            long people = total / time;
            cnt += people;
        }
        return cnt >= n;
    }
    
}