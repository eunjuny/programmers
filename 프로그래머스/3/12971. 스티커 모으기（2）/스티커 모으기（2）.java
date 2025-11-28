import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        int n = sticker.length;
        if (n == 1) return sticker[0];
        
        int case1 = dp(sticker, 0, n-2); // 원형이라 첫번째 스티커 뜯으면 마지막 스티커를 못 뜯음

        int case2 = dp(sticker, 1, n-1);
        
        return Math.max(case1, case2);
    }
    
    private int dp(int[] sticker, int start, int end) {
        int len = end - start + 1; // 0번 부터 시작했으므로
        
        if(len == 1) return sticker[start];
        
        int[] dp = new int[len];
        dp[0] = sticker[start];
        dp[1] = Math.max(sticker[start], sticker[start+1]);
        
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sticker[start + i]);
        }
        return dp[len - 1];
        
    }
}