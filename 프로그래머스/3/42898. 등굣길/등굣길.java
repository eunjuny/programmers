class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n+1][m+1];
        
        boolean[][] blocked = new boolean[n+1][m+1];
        
        for (int[] p : puddles) {
            int x = p[0];
            int y = p[1];
            blocked[y][x] = true;
        }
        
        dp[1][1] = 1;
        
        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= m; x++) {
                if(blocked[y][x] || (x==1 && y==1)) {
                    continue;
                }
                
                int top = dp[y-1][x];
                int left = dp[y][x-1];
                dp[y][x] = (top+left)%1000000007;
            }
        }
        
        return dp[n][m];
    }
} 