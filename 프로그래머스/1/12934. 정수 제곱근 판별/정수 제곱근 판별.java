class Solution {
    public long solution(long n) {
        long answer = -1;
        
        double d = Math.sqrt(n);
        System.out.println(d);
        if (d == (long) d) {
            answer = (long) Math.pow(d + 1, 2);
        }
        
        return answer;
    }
}