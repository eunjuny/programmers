class Solution {
    public int solution(int n) {
        int[] dp = new int[n+1];
        
        dp[0] = 1;  // 카탈란 수 기본값  (0쌍은 1가지)
        dp[1] = 1;  // 1쌍은 1가지
        
        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        
        return dp[n];
    }
}

/*
dp[3] = dp[0]*dp[2] + dp[1]*dp[1] + dp[2]*dp[0]
      = 1*2 + 1*1 + 2*1
      = 5
*/