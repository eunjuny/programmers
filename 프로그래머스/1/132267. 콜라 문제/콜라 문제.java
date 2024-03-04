class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        int x = 10000000;
        
        while(n >= a) {
            x = (n / a) * b;
            int y = n % a;

            answer += x;
            n = x + y;
        }
        
        if (n >= a) {
            answer = answer + ((n / a) * b);
        }
        
        return answer;
    }
}