class Solution {
    public int solution(String num_str) {
        int answer = 0;
        
        String[] numArr = num_str.split("");
        
        for(int i = 0; i < numArr.length; i++) {
            answer = answer + Integer.parseInt(numArr[i]);
        }
        
        return answer;
    }
}