import java.util.*;

public class Main {
    static int N;
    static int[][] board;
    static Map<Integer, Character> turnInfo = new HashMap<>();

    // 방향: 동, 남, 서, 북
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        board = new int[N][N];

        int K = sc.nextInt();
        for (int i = 0; i < K; i++) {
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;
            board[r][c] = 1; // 사과
        }

        int L = sc.nextInt();
        for (int i = 0; i < L; i++) {
            int time = sc.nextInt();
            char dir = sc.next().charAt(0);
            turnInfo.put(time, dir);
        }

        System.out.println(simulate());
    }

    static int simulate() {
        Deque<int[]> snake = new ArrayDeque<>();
        snake.add(new int[]{0, 0}); // initial

        int time = 0;
        int dir = 0; // 동쪽 방향

        while (true) {
            time++;

            int[] head = snake.peekLast();
            int nx = head[0] + dx[dir];
            int ny = head[1] + dy[dir];

            // 1. 벽 충돌
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                return time;
            }

            // 2. 몸 충돌
            for (int[] s : snake) {
                if (s[0] == nx && s[1] == ny) {
                    return time;
                }
            }

            // 3. 이동
            snake.addLast(new int[]{nx, ny});

            // 4. 사과 여부 확인
            if (board[nx][ny] == 1) {
                board[nx][ny] = 0; // 사과 먹음
            } else {
                snake.pollFirst(); // 꼬리 제거
            }

            // 5. 방향 전환
            if (turnInfo.containsKey(time)) {
                char t = turnInfo.get(time);
                if (t == 'D') {
                    dir = (dir + 1) % 4; // 오른쪽 회전
                } else {
                    dir = (dir + 3) % 4; // 왼쪽 회전
                }
            }
        }
    }
}
