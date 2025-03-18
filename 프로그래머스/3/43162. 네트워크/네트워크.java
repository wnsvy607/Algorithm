import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        parent = new int[n];

        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) continue;
                if(computers[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < n; i++) {
            set.add(find(i));
        }

        return set.size();
    }


    int[] parent;

    int find(int u) {
        if(u == parent[u]) return u;
        return parent[u] = find(parent[u]);
    }

    boolean union(int u, int v) {
        int pu = find(u);
        int pv = find(v);

        if(pu == pv) return false;

        parent[pu] = pv;

        return true;
    }


}