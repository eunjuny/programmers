import java.util.*;

class Solution {
    
    int[] parent;
    
    public int solution(int n, int[][] costs) {
        //비용 기준 정렬
        Arrays.sort(costs, (a,b) -> a[2] - b[2]);
        
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        int total = 0;
        int cnt = 0;
        
        // 비용 낮은 간선부터 선택
        for (int[] edge : costs) {
            int a = edge[0];
            int b = edge[1];
            int cost = edge[2];
            
            // 서로 다른 부모면 합침
            if (find(a) != find(b)) {
                union(a, b);
                total += cost;
                cnt++;
                
                // 간선 개수는 최대 n-1이라서 n-1이면 MST 완성
                if(cnt == n -1) break;
            }
        }
        
        return total;
    }
    
    // 부모 찾기 - 경로 압축
    // 처음에는 자기 자신이 부모였지만 나중엔 합쳐져서 부모 하나에 여럿이 속하게 됨
    private int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    // 두 집합 합치기
    private void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        parent[pb] = pa; 
    }
}
