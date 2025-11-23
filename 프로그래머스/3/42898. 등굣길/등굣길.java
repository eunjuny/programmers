class Solution {
    public int solution(int m, int n, int[][] puddles) {
        // 시작점이 1,1이기 때문에 n, m 에 +1을 해준다.
        int[][] dp = new int[n+1][m+1];
        // 물웅덩이
        boolean[][] blocked = new boolean[n+1][m+1];
        
        for(int[] p : puddles) {
            int x = p[0];
            int y = p[1];
            blocked[y][x] = true;
        }
        
        // 시작점
        dp[1][1] = 1; 
        
        for(int y = 1; y <= n; y++) {
            for(int x = 1; x <= m; x++) {
                
                if(blocked[y][x] || (x==1 && y==1)) continue;
                
                // 해당 칸까지 갈 수 있는 방법의 수는 해당 칸의 윗칸 까지의 방법의 수 + 왼칸 까지의 방법의 수 
                int fromTop = dp[y-1][x];
                int fromLeft = dp[y][x-1];
                dp[y][x] = (fromTop + fromLeft) % 1000000007;
            }
        }
        
        
        
        return dp[n][m];
    }
}