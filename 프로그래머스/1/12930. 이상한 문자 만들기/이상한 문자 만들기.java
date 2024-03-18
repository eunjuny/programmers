class Solution {
    public String solution(String s) {
        String answer = "";
        String[] stList = s.split("");
        int idx = 0;
        
        for (int i = 0; i < stList.length; i++) {
            if ((" ").equals(stList[i])) {
                idx = 1;   // " "일 경우 idx를 홀수로 초기화
            }
            
            answer += idx % 2 == 0 ? stList[i].toUpperCase() : stList[i].toLowerCase(); 
            //  " "은 대소문자 구분이 없으므로 신경쓰지 않아도 됨
            idx++;
        }
        return answer; 
    }
}