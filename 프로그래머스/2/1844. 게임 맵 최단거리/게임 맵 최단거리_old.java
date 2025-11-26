import java.util.*;

class Solution {
    
    // 상하좌우
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        int[][] visited = new int[maps.length][maps[0].length];
        
        bfs(maps, visited);
        
        answer = visited[maps.length -1][maps[0].length -1];
        return  answer >= 1 ? answer : -1;
    }
    
    private void bfs(int[][] maps, int[][] visited) {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offerFirst(new int[]{0,0}); // 시작 점
        visited[0][0] = 1; // 시작 점 방문 체크
        
        while(!dq.isEmpty()) {
            int[] curr = dq.pollFirst();
            int x = curr[0];
            int y = curr[1];
            
            // 상하좌우 인접 정점 체크
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length) {
                    continue;
                }
                
                if(maps[nx][ny] == 1 && visited[nx][ny] ==0) {
                    visited[nx][ny] = visited[x][y] +1;
                    dq.offerLast(new int[]{nx, ny});
                }
            }
        }
    }
}
