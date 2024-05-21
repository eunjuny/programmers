class Solution {
    public int solution(int n, int k) {
        
        // n을 k진수로 변환
        String kNumber = Integer.toString(n, k); 
        
        // k진수로 변환된 문자열을 "0"을 기준으로 분할
        String[] arr = kNumber.split("0");
        
        int cnt = 0;
        
        for (String ar : arr) {
            // 빈 문자열은 무시
            if (ar.isEmpty()) continue;
            
            // 정수로 변환한 후 소수 체크
            if (isPrime(Long.parseLong(ar))) {
                cnt++;
            }
        }
        
        return cnt;
    }
    
    private boolean isPrime(long n) {
        if (n <= 1) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        
        for (long i = 5; i*i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}