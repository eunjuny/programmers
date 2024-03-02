class Solution {
    public String solution(int[] food) {
        String answer = "";
        String halfAnswer = "";
        
        for (int i = 1; i < food.length; i++) {
            if (food[i] % 2 != 0) {
                food[i] = (food[i] - 1) / 2;
            } else {
                food[i] = food[i] / 2;
            }
            
            for (int j = 0; j < food[i]; j++) {
                halfAnswer = halfAnswer + "" + i;
            }
        }
        StringBuffer sb = new StringBuffer(halfAnswer);       
        answer = halfAnswer + "0" + sb.reverse().toString();
        
        return answer;
    }
}