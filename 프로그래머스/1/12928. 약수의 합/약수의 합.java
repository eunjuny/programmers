class Solution {
    public int solution(int n) {
        int answer = 0;
        
        if (n < 2) {
            return n;
        }
        double d = Math.sqrt(n);
        int sq = (int) d;
        if (d % 1 == 0.0) {
            answer += sq;
        }
        
        for (int i = 1; i < d; i++) {
            if (n % i == 0) {
                answer += n/i;
                answer += i;
            }
            
        }
        return answer;
    }
}