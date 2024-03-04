class Solution {
    public int solution(String[] babbling) {
        int answer = 0; 
        
        String a = "aya";
        String b = "ye";
        String c = "woo";
        String d = "ma";
        
        for (int i = 0; i < babbling.length; i++) {
            if (babbling[i].contains(a+a) || babbling[i].contains(b+b) || babbling[i].contains(c+c) || babbling[i].contains(d+d)) {
                continue;
            }
            
            babbling[i] = babbling[i].replace(a, " ");
            babbling[i] = babbling[i].replace(b, " ");
            babbling[i] = babbling[i].replace(c, " ");
            babbling[i] = babbling[i].replace(d, " ");
            babbling[i] = babbling[i].replace(" ", "");
            
            if (babbling[i].length() == 0) {
                answer++;
            }
        }
        return answer;
    }
}