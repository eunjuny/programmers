import java.util.*;

class Solution {
    int[] parent;
    public int solution(int n, int[][] costs) {
        
        // 비용 순으로 오름차순 정렬
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        
        parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        int total = 0;
        int cnt = 0;
        
        for (int[] c : costs) {
            int a = c[0];
            int b = c[1];
            int cost = c[2];
            
            if(find(a) != find(b)) {
                union(a, b);
                total += cost;
                cnt++;
            }
            
            // 간선 개수는 최대 n-1개
            if(cnt == n-1) break;
        }
        
        return total;
    }
    
    private int find(int i) {
        if(parent[i] == i) return i;
        
        return parent[i] = find(parent[i]);
    }
    
    private void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) parent[b] = a;
    }
}