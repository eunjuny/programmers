class Solution {
    public String solution(String s) {
        String answer = "";
        int leng = s.length();
        if (leng % 2 == 0) {
            int idx = leng / 2;
            answer = s.substring(idx - 1, idx + 1);
        } else {
            int idx = (leng - 1) / 2;
            answer = s.substring(idx, idx + 1);
        }
        return answer;
    }
}