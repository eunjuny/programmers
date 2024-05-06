import java.util.Arrays;

class Solution {
    public int[] solution(int n, long left, long right) {
        int le = (int) left;
        int ri = (int) right;
        int[] answer = new int[ri - le + 1];
        
        // 이 행렬은 해당 행과 열의 숫자 중 더 큰 숫자를 값으로 가진다.
        int idx = 0;
        for (long i = left; i <= right; i++) {
            long row = i / n + 1;
            long col = i % n + 1;
            answer[idx++] = (int) Math.max(row, col);
        }
        return answer;
    }
}