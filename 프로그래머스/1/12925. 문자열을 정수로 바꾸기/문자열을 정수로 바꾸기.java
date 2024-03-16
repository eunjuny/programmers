class Solution {
    public int solution(String s) {
        int answer = 0;

        if (s.substring(0,1) == "-") {
            answer = -(Integer.parseInt(s));    
        } else {
            answer = Integer.parseInt(s);
        }
        
        
        return answer;
    }
}