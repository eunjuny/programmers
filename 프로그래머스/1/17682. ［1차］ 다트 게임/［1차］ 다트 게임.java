class Solution {
    public int solution(String dartResult) {
        char[] ch = dartResult.toCharArray();
        
        int score[] = new int[3];
        int idx = 0;
        
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] >= '0' && ch[i] <= '9') {
                if (score[idx] == 1 && ch[i] == '0') {
                    score[idx] = 10;
                } else 
                score[idx] = ch[i] - '0';
            }
            
            if (ch[i] == 'D') {
                score[idx] = score[idx] * score[idx];
                idx++;
            } else if (ch[i] == 'T') {
                score[idx] = score[idx] * score[idx] * score[idx];
                idx++;
            } else if (ch[i] == 'S'){
                idx++;
            }
            
            if (ch[i] == '*') {
                if (idx > 1) {
                    score[idx - 2] = score[idx - 2] * 2;
                }
                score[idx - 1] = score[idx - 1] * 2;
            } else if (ch[i] == '#') {
                score[idx - 1] = -score[idx - 1];
            }
        }
        
            System.out.println(score[0]);
            System.out.println(score[1]);
            System.out.println(score[2]);
        return score[0] + score[1] + score[2];
    }
}