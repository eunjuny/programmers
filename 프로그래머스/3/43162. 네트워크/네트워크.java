import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(i, visited, n, computers); 
                answer++;
            }
        }
        
        return answer;
    }
    
    private void dfs(int start, boolean[] visited, int n, int[][] computers) {
        visited[start] = true;
        
        for (int j = 0; j < n; j++) {
            if(computers[start][j] == 1 && !visited[j]) {
                dfs(j, visited, n, computers);
            }
        }
    }
}