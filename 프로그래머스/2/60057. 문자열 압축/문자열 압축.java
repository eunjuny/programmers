import java.util.*;

class Solution {
    public int solution(String s) {
        int len = s.length();
        int answer = len;
        
        for(int unit = 1; unit <= len/2; unit++) {
            StringBuilder sb = new StringBuilder();
            String prev = s.substring(0, unit);
            int cnt = 1;
            
            for(int i = unit; i < len; i+=unit) {
                String next;
                if(i + unit <= len) next = s.substring(i, i+unit);
                else next = s.substring(i);
                
                if(prev.equals(next)) {
                    cnt++;
                } else {
                    if(cnt > 1) {
                        sb.append(cnt);
                    }
                    sb.append(prev);
                    cnt = 1;
                    prev = next;
                }
            }
            if(cnt > 1) {
                sb.append(cnt); // cnt++ 됐지만 i>=len이 돼서 sb.append없이 for문이 종료된 경우
            }
            sb.append(prev);
            answer = Math.min(answer, sb.length());
        }
        
        return answer;
    }
}