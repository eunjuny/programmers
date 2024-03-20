class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        char[] c = s.toCharArray(); // 배열에 공백도 포함됨
        int nn = n % 26;    // 26으로 남은 나머지 만큼 ascii코드로 더하기
        
        for (int i = 0; i < c.length; i++) {
            if (c[i] >= 'A' && c[i] <= 'Z') {
                char ch = (char) (c[i] + nn > 'Z' ? c[i] + nn - 26 : c[i] + nn);
                answer.append(ch);
            } else if (c[i] >= 'a' && c[i] <= 'z') {
                char ch = (char) (c[i] + nn > 'z' ? c[i] + nn - 26 : c[i] + nn);
                answer.append(ch);
            } else {
                answer.append(c[i]);
            }
        }
        return answer.toString();
    }
    
}