import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        int[] dist = new int[n+1];  // 1번 노드부터 각 노드 까지의 거리
        Arrays.fill(dist, -1);  //   방문 안 한 노드는 -1
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offerLast(1);    // 시작 노드
        dist[1] = 0;
        
        while(!dq.isEmpty()) {
            int node = dq.pollFirst();
            for (int next : graph.get(node)) {  // 해당 노드와 연결된 노드 목록
                if(dist[next] == -1) {
                    dist[next] = dist[node] + 1;    // node까지의 거리 +1
                    dq.offerLast(next);
                }
            }
        }
        
        int maxDist = 0;
        for (int d : dist) {
            if (d > maxDist) {
                maxDist = d;
            }
        }
        
        int count = 0;
        for (int d : dist) {
            if (d == maxDist) {
                count++;
            }
        }
        
        
        return count;
    }
}