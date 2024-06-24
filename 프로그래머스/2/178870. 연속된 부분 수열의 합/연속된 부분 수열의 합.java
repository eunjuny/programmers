class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {-1,-1};
        int left = 0, right = 0;
        int sum = 0;
        
        while (right < sequence.length) {
            sum += sequence[right];
            
            while (sum > k && left <= right) {
                sum -= sequence[left];
                left++;
            }
            
            if (sum == k) {
                if (answer[0] == -1 || (right - left < answer[1] - answer[0])) {
                    answer[0] = left;
                    answer[1] = right;
                }
            }
            
            right++;
        }
        
        return answer;
    }
}