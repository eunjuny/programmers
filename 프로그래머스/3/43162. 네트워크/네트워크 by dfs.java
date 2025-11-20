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
                dfs(i, computers, visited, n);
            }
        }
        
        return answer;
    }
    
    private void dfs(int i, int[][] computers, boolean[] visited, int n) {
        visited[i] = true;
        
        for (int j = 0; j < n; j++) {
            // 기준 컴퓨터와 연결 된 컴퓨터이면서 -> computers[i][j] ==1
            // 아직 방문하지 않은 컴퓨터 -> !visited[j]
            if(computers[i][j] == 1 && !visited[j]) {
                dfs(j, computers, visited, n);
            }
        }
    }
}
