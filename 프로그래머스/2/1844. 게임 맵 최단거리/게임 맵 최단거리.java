import java.util.*;

class Solution {        
    int[] mX = new int[]{0,0,-1,1};
    int[] mY = new int[]{1,-1,0,0};
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        int[][] distance = new int[maps.length][maps[0].length];    // 빈 칸에 0이 자동 초기화됨
       
        bfs(maps, distance);
        
        answer = distance[maps.length-1][maps[0].length-1];
        return answer == 0 ? -1 : answer;
    }
    
    private void bfs(int[][] maps, int[][]distance) {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offerLast(new int[]{0,0});
        distance[0][0] = 1;
        
        while(!dq.isEmpty()) {
            int[] curr = dq.pollFirst();
            int x = curr[1];
            int y = curr[0];
            
            for(int i = 0; i < 4; i++){
                int toX = x + mX[i];
                int toY = y + mY[i];
                if(toX < 0 || toY < 0 || toY >= maps.length || toX >= maps[0].length) {
                    continue;
                }
                if(maps[toY][toX] != 0 && distance[toY][toX] == 0) {
                    distance[toY][toX] = distance[y][x] + 1;
                    dq.offerLast(new int[]{toY, toX});
                }
            }
        }
    }
}