import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        // DP(Dynamic Programming)
        // 각 칸에서 만들 수 있는 경로 합을 아래에서 위로 올라가면서 계산
        for (int i = triangle.length-2; i >= 0; i--) {  // 맨 아래 줄 바로 위 줄 부터 시작(맨 아래 줄은 이미 최대 합인 상태이므로)
            for(int j =0; j<triangle[i].length; j++) {
                // 해당 칸에서 가능한 최대 합으로 바꿔가면서 올라감
                triangle[i][j] += Math.max(triangle[i+1][j], triangle[i+1][j+1]);  
            }
        }
        
        return triangle[0][0];
    }
}
