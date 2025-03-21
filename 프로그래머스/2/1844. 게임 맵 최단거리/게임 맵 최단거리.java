import java.util.*;

class Solution {
    
    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    
    public int solution(int[][] maps) {
        int cnt = 0;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1});
        
        int m = maps.length;
        int n = maps[0].length;
        
        boolean[][] visited = new boolean[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                visited[i][j] = maps[i][j] == 0;
            }
        }
        
        while(!q.isEmpty()) {
            
            int[] pos = q.poll();
            int y = pos[0];
            int x = pos[1];
            int cost = pos[2];
            
            if(visited[y][x]) continue;
            visited[y][x] = true;
            
            if(y == m - 1 && x == n - 1) return cost;
            
            for(int[] direction : dir) {
                int cy = y + direction[0];
                int cx = x + direction[1];
                
                if(cy >= m || cx >= n || cy < 0 || cx < 0 || visited[cy][cx]) continue;
                
                q.add(new int[]{cy, cx, cost + 1});
            }
            
            
            
        }
        
        
        
        return -1;
    }
    
    
}