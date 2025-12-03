import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(visited, computers, i, n);
                answer++;
            }
        }
        
        return answer;
    }
    
    private void dfs(boolean[] visited, int[][] computers, int start, int n) {
        visited[start] = true;
        for(int j = 0; j < n; j++) {
            if(computers[start][j] == 1 && !visited[j]) {
                dfs(visited, computers, j, n);
            }
        }    
        
    }
}