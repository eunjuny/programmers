import java.lang.Math;

class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for (int i = left; i <= right; i++) {
            double x = Math.sqrt(i);
            if (x % 1 == 0) {
                answer -= i;
            } else {
                answer += i;
            }
        }
        return answer;
    }
}