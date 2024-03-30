class Solution {
    public int solution(int n) {
    	int answer = 0;
        
        for (int i = 2; i <= n; i++) {
            answer += isPrime(i);
        }
        
        return answer;
    }
    
    private int isPrime(int i) {
        int result = 1;
        
        for (int j = 2; j <= Math.sqrt(i); j++) {
            if (i % j == 0) {
                result = 0;
                break;
            }    
        }
    
        return result;
    }
}