import java.lang.Math;

class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        
        while(n > 0) {
            sb.append(n % 3);
            n /= 3;
        }
        
        for (int i = 0; i < sb.length(); i++) {
            int num = (int)sb.charAt(sb.length() - (i+1)) - 48;
            answer += num * (Math.pow(3, i));
        }
        
        System.out.println(sb);
        return answer;
    }
}