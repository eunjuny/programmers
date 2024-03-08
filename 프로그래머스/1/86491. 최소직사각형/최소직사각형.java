class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int maxw = 0;
        int maxh = 0;
            for (int i = 0; i < sizes.length; i++) {
                if (maxw < Math.max(sizes[i][0], sizes[i][1])) {
                    maxw = Math.max(sizes[i][0], sizes[i][1]); 
                }
                if (maxh < Math.min(sizes[i][0], sizes[i][1])) {
                    maxh = Math.min(sizes[i][0], sizes[i][1]); 
                }
            }
        answer = maxw * maxh;
        return answer;
    }
}