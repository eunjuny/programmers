import java.util.Arrays;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = new int[progresses.length];
        int[] total = new int[progresses.length];
        
        for (int i = 0; i < progresses.length; i++) {
            // Math.ceil은 값을 올림한다. 이 때 double형을 인수로 받아야 하기 때문에 (double)로 변환한 뒤 계산하고 다시 (int)로 변환
            total[i] = (int)Math.ceil((double)(100 - progresses[i]) / speeds[i]);
        }
        
        int idx = 0;
        int idx2 = 0;
        int cnt = 0;
        
        // idx2가 배열의 길이보다 작을 때 까지 계산
        while(idx < progresses.length) {
            if (total[idx] >= total[idx2]) {
                cnt++;
                idx2++;
                if (idx2 >= progresses.length) {
                    answer[idx] = cnt;
                    idx = idx2;
                    cnt = 0;
                    break;
                }
            } else {
                answer[idx] = cnt;
                idx = idx2;
                cnt = 0;
            }
        }
        
        // 0인 배열 제거
        return Arrays.stream(answer).filter(f -> f != 0).toArray();
    }
}