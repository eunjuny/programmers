import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        boolean[][] block = new boolean[n+1][m+1]; 
        for(int[] puddle : puddles) {
            int x = puddle[0];
            int y = puddle[1];
            block[y][x] = true;
        } 
        
        int[][] dp = new int[n+1][m+1];
        dp[1][1] = 1;
        
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(block[j][i] || (i==1 && j==1)) continue;
                
                int top = dp[j-1][i];
                int left = dp[j][i-1];
                dp[j][i] = (top+left)%1000000007;
            }
        }
        
        return dp[n][m];
    }
}