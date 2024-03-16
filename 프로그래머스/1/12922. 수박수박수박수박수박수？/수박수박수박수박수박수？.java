class Solution {
    public String solution(int n) {
        String answer = "";
        StringBuilder wm = new StringBuilder("");
       
        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) {
                wm = wm.append("수");
            } else {
                wm = wm.append("박");
            }
        }
        answer = wm.toString();
        return answer;
    }
}