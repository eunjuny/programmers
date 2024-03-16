import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        String st = String.valueOf(n);
        for (int i = 0; i < st.length(); i++) {
            answer += Integer.parseInt(st.split("")[i]);
        }

        return answer;
    }
}