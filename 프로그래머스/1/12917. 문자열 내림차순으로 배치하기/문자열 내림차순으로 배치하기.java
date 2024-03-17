import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int[] ia = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            ia[i] = s.charAt(i);
        }
        Arrays.sort(ia);
        for(int i : ia) {
            answer.append((char)i);
        }
        
        return answer.reverse().toString();
    }
}