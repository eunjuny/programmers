import java.util.*;

class Solution {
    // 이동 방향을 나타내는 배열 (상, 하, 좌, 우)
    static int[] dRow = {1, -1, 0, 0};
    static int[] dCol = {0, 0, 1, -1};
    static List<Integer> list;
    
    public int solution(String[] board) {
        int INF = Integer.MAX_VALUE; // 무한대를 나타내는 상수
        int[][] dist = new int[board.length][board[0].length()]; // 거리 배열
        int[] start = new int[2]; // 시작 위치
        int[] target = new int[2]; // 목표 위치

        // 보드를 순회하면서 시작 위치와 목표 위치를 찾음
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length(); j++) {
                if (board[i].charAt(j) == 'R') {
                    start = new int[] {i, j}; // 시작 위치 저장
                }

                if (board[i].charAt(j) == 'G') {
                    target = new int[] {i, j}; // 목표 위치 저장
                }

                dist[i][j] = INF; // 거리 배열을 무한대로 초기화
            }
        }

        bfs(board, dist, start); // BFS 알고리즘을 사용하여 거리 계산

        // 목표 위치까지의 거리가 여전히 무한대라면 -1 반환
        if (dist[target[0]][target[1]] == INF) {
            return -1;
        }

        return dist[target[0]][target[1]]; // 목표 위치까지의 거리 반환
    }
    
    public void bfs(String[] board, int[][] dist, int[] start) {
        // 우선순위 큐를 사용하여 BFS 구현 (거리 기준 오름차순)
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> dist[o[0]][o[1]]));
        queue.add(start); // 시작 위치를 큐에 추가
        dist[start[0]][start[1]] = 0; // 시작 위치의 거리를 0으로 설정

        // 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            int[] nowPosition = queue.poll(); // 현재 위치를 큐에서 꺼냄
            int row = nowPosition[0];
            int col = nowPosition[1];

            // 4가지 방향으로 이동 시도
            for (int i = 0; i < 4; i++) {
                int nextRow = row;
                int nextCol = col;
                int move = 0;

                // 벽이나 장애물에 부딪힐 때까지 한 방향으로 이동
                while (true) {
                    int newRow = nextRow + dRow[i];
                    int newCol = nextCol + dCol[i];

                    if (newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[0].length() || board[newRow].charAt(newCol) == 'D') {
                        break; // 보드 범위를 벗어나거나 장애물에 도달하면 이동 중지
                    }

                    nextRow = newRow;
                    nextCol = newCol;
                    move = 1; // 이동이 발생했음을 표시
                }

                // 현재 위치에서 다음 위치로의 이동이 거리를 단축시키는 경우
                if (dist[row][col] + move < dist[nextRow][nextCol]) {
                    dist[nextRow][nextCol] = dist[row][col] + move; // 거리 갱신
                    queue.add(new int[] {nextRow, nextCol}); // 다음 위치를 큐에 추가
                }
            }
        }
    }
}
