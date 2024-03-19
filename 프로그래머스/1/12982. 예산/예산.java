import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int cost = 0;
        Arrays.sort(d);
        for (int i = 0; i < d.length; i++) {
            cost += d[i];
            if (cost <= budget) {
                answer++;
            }
        }
        return answer;
    }
}