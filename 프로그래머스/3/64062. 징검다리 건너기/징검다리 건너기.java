class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        // 중간 기준으로 반으로 나눠서 계산
        
        int left = 1;
        int right = 0;
        for(int stone : stones) {
            if(stone > right) right = stone;    // 가장 큰 디딤돌
        }

        while (left <= right) {
            int mid = (left + right) / 2;
            if (canCross(stones, k, mid)) {
                answer = mid;   // mid 명은 건널 수 있음.
                left = mid + 1; // 현재 mid보다 큰 새로운 mid 구해서 탐색
            } else {
                right = mid - 1; // 현재 mid보다 작은 새로운 mid 구해서 탐색
            }
        }
        
        return answer;
    }
    
    private boolean canCross(int[] stones, int k, int mid) {
        int consecutive = 0;    // 연이은 0 디딤돌 개수
        for(int s : stones) {
            if (s < mid) {
                consecutive++;
                if(consecutive >= k) return false;  // 실패가 연속 k개 이상이면 못건넘
            } else {
                consecutive = 0; // 끊기면 리셋
            }
        }
        return true;    // mid명은 건널 수 있음.
    }
}