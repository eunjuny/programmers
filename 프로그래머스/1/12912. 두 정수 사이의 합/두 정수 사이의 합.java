class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        
        if (a == b) {
            return a;
        } else {
            int x = 0;
            int y = 0;
            if (a > b) {
                x = b;
                y = a;
            } else {
                x = a;
                y = b;
            }
            
            for (int i = x; i <= y; i++) {
                answer += i;
            }
        }
        return answer;
    }
}