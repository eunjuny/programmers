import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        int h = 0;
        for (int i = 0; i < citations[citations.length-1]; i++) {
            int cnt = 0;
            for (int j = 0; j < citations.length; j++) {
                if (citations[j] >= h) {
                    cnt++;
                }
            }
            if (h <= cnt) {
                answer = h;
            }
            h++;
        }
        
        return answer;
    }
}