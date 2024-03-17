class Solution {
    public boolean solution(String s) {
        boolean answer = false;
        int len = s.length();
        if (len == 4 || len == 6) {
            boolean isDigit = true;
            for (int i = 0; i < len; i++) {
                System.out.println(s.charAt(i));
                if (!(s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                    isDigit = false;
                }
            }
            answer = isDigit;
        }
        return answer;
    }
}