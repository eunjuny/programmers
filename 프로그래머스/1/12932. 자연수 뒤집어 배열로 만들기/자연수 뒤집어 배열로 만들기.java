import java.util.*;

class Solution {
    public int[] solution(long n) {
        String[] s = String.valueOf(n).split("");
        int[] answer = new int[s.length];
        
        int idx = s.length - 1;
        for (int i = 0; i < s.length; i++) {
            answer[idx--] = Integer.parseInt(s[i]);
        }
        return answer;
    }
}