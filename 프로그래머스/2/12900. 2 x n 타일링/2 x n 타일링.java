class Solution {
    public int solution(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        
        //  dp[i]는 dp[i-1] + dp[i-2] 
        //  dp[i-1]에서 세로 한 개 붙이거나 dp[i-2]에서 가로 두 개를 붙이거나
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
        }
        
        return dp[n];
    }
}