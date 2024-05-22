import java.util.*;

class Solution {
    
    // 상하좌우로 이동할 수 있는 방향을 정의
    int[] dx = {0, 1, -1, 0}; // x축 방향 (우, 하, 상, 좌)
    int[] dy = {1, 0, 0, -1}; // y축 방향 (우, 하, 상, 좌)
    
    public int solution(int[][] maps) {
        
        int answer = 0;

        // 방문 여부를 기록할 배열
        int[][] visited = new int[maps.length][maps[0].length];

        // BFS를 이용해 최단 경로를 찾는다
        bfs(maps, visited);

        // 상대 팀 진영 (목적지) 좌표의 방문 여부를 확인
        answer = visited[maps.length - 1][maps[0].length - 1];

        // 목적지에 도달하지 못한 경우 -1을 반환
        if (answer == 0) {
            answer = -1;
        }

        return answer;
    }
    
    public void bfs(int[][] maps, int[][] visited) {

        // BFS를 위한 큐를 초기화하고 시작 위치를 추가
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0}); // 시작 정점 (0, 0)
        visited[0][0] = 1; // 시작 정점을 방문했음을 표시 (거리 1)

        // 큐가 빌 때까지 BFS를 수행
        while (!q.isEmpty()) {

            // 큐에서 현재 정점을 꺼냄
            int[] current = q.poll();
            int X = current[0]; // 현재 x좌표
            int Y = current[1]; // 현재 y좌표

            // 현재 정점의 상하좌우 인접 정점을 탐색
            for (int i = 0; i < 4; i++) {

                int nX = X + dx[i]; // 인접 정점의 x좌표
                int nY = Y + dy[i]; // 인접 정점의 y좌표

                // 인접 정점이 maps의 범위를 벗어나는 경우 무시
                if (nX < 0 || nX >= maps.length || nY < 0 || nY >= maps[0].length) {
                    continue;
                }

                // 인접 정점이 아직 방문하지 않았고, 벽이 아닌 경우
                if (visited[nX][nY] == 0 && maps[nX][nY] == 1) {
                    // 현재 정점까지의 거리 + 1을 기록
                    visited[nX][nY] = visited[X][Y] + 1;
                    // 인접 정점을 큐에 추가
                    q.add(new int[]{nX, nY});
                }
            }
        }
    }
}
