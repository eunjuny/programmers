class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int coverage = 2 * w + 1;
        int notCovered = 1;
        
        for(int st : stations) {
            int left = st - w;
            int right = st + w;
            
            if(left > notCovered) {
                answer += (left - notCovered) / coverage;
                if ((left - notCovered) % coverage > 0){
                    answer++;
                }
            }
            
            notCovered = right + 1;
        }
        
        if (notCovered <= n) {
            answer += (n - notCovered + 1) / coverage;
            if ((n - notCovered + 1) % coverage > 0) {
                answer++;
            }
        }
        
        return answer;
    }
}