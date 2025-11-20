import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        // 방문 여부
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            // 아직 방문하지 않은 컴퓨터 -> 새로운 네트워크 시작
            if(!visited[i]) {
                answer++;
                // 새로운 컴퓨터로 부터 연결된 컴퓨터 탐색
                bfs(i, computers, visited, n);
            }
        }
        
        return answer;
    }
    
    private void bfs(int start, int[][] computers, boolean[] visited, int n) {
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(start);
        visited[start] = true;
        
        while (!queue.isEmpty()){
            int now = queue.poll();
            
            for(int j = 0; j < n; j++) {
                if (computers[now][j] == 1 && !visited[j]) {
                    visited[j] = true;
                    queue.add(j);
                }
            }
        }
    }
}
