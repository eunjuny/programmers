class Solution {
    public int solution(int n) {
        int answer = 0;
        int one = 0;
        int two = 1;
        int pb = 0;
        
        for (int i = 1; i < n; i++) {
            pb = (one + two) % 1234567;
            one = two;
            two = pb;
        }
        
        answer = pb ;
        return answer;
    }
}