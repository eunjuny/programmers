class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder sequence = new StringBuilder();
        
        int num = 0;
        
        while (sequence.length() < t * m) {
            sequence.append(Integer.toString(num++, n));
        }
        
        for (int i = 0; i < t; i++) {
            answer.append(sequence.charAt(i * m + (p - 1)));
        }
        return answer.toString().toUpperCase();
    }
}