class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
      
        for (int i = 0; i < s.length(); i++) {
            // substring(i, j) 는 i부터 j전까지 (j 불포함) 
            int idx = s.substring(0,i).lastIndexOf(s.charAt(i));
           if (i != 0) {
                if (idx != -1) {
                answer[i] = (i - idx);
            	} else {
                answer[i] = idx;
            	}
           } else {
               answer[i] = -1;
           }
        }
        
        return answer;
    }
}