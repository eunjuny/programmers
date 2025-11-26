import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                bfs(i, visited, computers, n);
                answer++;
            }
        }
        
        return answer;
    }
    
    private void bfs(int start, boolean[] visited, int[][] computers, int n) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offerFirst(start);
        visited[start] = true;
        
        while(!dq.isEmpty()) {
            int curr = dq.pollFirst();
            for(int j = 0; j < n; j++) {
                if(!visited[j] && computers[curr][j] == 1){
                    visited[j] = true;
                    dq.offerFirst(j);
                }
            }
        }
    }
}