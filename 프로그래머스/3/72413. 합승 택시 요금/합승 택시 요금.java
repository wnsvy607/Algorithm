import java.util.*;

class Solution {
    
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        
        var distS = getDistances(n, s, fares);
        var distA = getDistances(n, a, fares);
        var distB = getDistances(n, b, fares);
        
        int minCost = distS[a] + distS[b];
        
        for(int i = 1; i <= n; i++) {
            int cost = distS[i] + distA[i] + distB[i];
            minCost = Math.min(minCost, cost);
        }
        
        
        
        return minCost;
    }
    
    int[] getDistances(int n, int start, int[][] fares) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        
        
        List<Node>[] nodes = new List[n + 1];
        
        for(var fare : fares) {
            int a = fare[0]; int b = fare[1]; int cost = fare[2];
            
            if(nodes[a] == null) nodes[a] = new ArrayList<>();
            if(nodes[b] == null) nodes[b] = new ArrayList<>();
            
            nodes[a].add(new Node(b, cost));
            nodes[b].add(new Node(a, cost));
            
        }
        
        
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            
            
            for(var next : nodes[node.idx]) {
                
                if(dist[next.idx] <= dist[node.idx] + next.dist) continue;
                
                dist[next.idx] = dist[node.idx] + next.dist;
                
                pq.add(new Node(next.idx, dist[next.idx]));
            }
        }
        
        
        return dist;
    }
    
    static class Node implements Comparable<Node> {
        int idx;
        int dist;
            
        Node(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
        
        
        @Override
        public int compareTo(Node n) {
            return Integer.compare(this.dist, n.dist);
        }
        
        
    }
    
    
}