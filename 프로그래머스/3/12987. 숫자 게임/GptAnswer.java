import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int score = 0;
        int indexA = 0;
        
        for (int b : B) {
            if (b > A[indexA]) {
                score++;
                indexA++;
            }
        }
        return score;
    }
}
