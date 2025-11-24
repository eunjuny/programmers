import java.util.*;

class Solution {
    public int solution(int[] money) {
        
        int n = money.length;
        
        // 첫 집 털고, 마지막 집 못 털기
        int case1 = rob(money, 0, n-2);
        // 첫 집 안 털고, 마지막 집 털기
        int case2 = rob(money, 1, n-1);
        
        return Math.max(case1, case2);
    }
    
    private int rob(int[] money, int start, int end) {
        int prev2 = 0;
        int prev1 = 0;
        
        for (int i = start; i <= end; i++) {
            int curr = Math.max(prev1, prev2 + money[i]);
            prev2 = prev1;
            prev1 = curr;
        }
        
        return prev1;
    }
}