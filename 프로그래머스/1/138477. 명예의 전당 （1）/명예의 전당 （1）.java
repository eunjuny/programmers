import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> scoreList = new ArrayList<>();
        
        for (int i = 0; i < score.length; i++) {
            scoreList.add(score[i]);
            Collections.sort(scoreList, Collections.reverseOrder());
            if (i < k) {
                answer[i] = (scoreList.get(i));
            } else {
                answer[i] = (scoreList.get(k-1));
            }
        }
        return answer;
    }
}