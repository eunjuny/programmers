class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
        int nums = 0;
        int cnt = 0;
        
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] != 0) {
                nums++;
                for (int j = 0; j < win_nums.length; j++) {
                    if (lottos[i] == win_nums[j]) {
                        cnt++;
                    }
                }
            } 
        }
        
        int min = 1 + (nums - cnt) > 6 ? 6 : 1 + (nums - cnt); 
        int max = cnt >= 2 ? 7 - cnt : 6;
        
        int[] answer = {min, max};
            
        return answer;
    }
}