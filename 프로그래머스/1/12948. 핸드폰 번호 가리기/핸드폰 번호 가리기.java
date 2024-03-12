class Solution {
    public String solution(String pn) {
        String answer = "";
        // StringBuilder sb = new StringBuilder(pn);
        
        int idx = pn.length();
        while(idx > 4) {
            answer += "*";
            idx--;
        }
        answer = answer + pn.substring(pn.length() - 4, pn.length());
        
        return answer;
    }
}