class Solution {
    boolean solution(String s) {
        boolean answer = true;
		int leftCnt = 0;
        int rightCnt = 0;
        for(int i=0; i<s.length(); i++){
			if('(' == s.charAt(i)){ 
                leftCnt++ ;
                }else {
                rightCnt++;
            }
            if(rightCnt > leftCnt) {
                return false;
            }
        }
        return leftCnt == rightCnt; 
    }
}