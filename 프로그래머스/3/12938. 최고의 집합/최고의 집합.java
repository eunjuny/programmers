class Solution {
    public int[] solution(int n, int s) {
        
        if(s < n) return new int[]{-1};
        
        int[] answer = new int[n];
        
        int base = s/n;
        int extra = s%n;
        
        for(int i = 0; i < n; i++){
            answer[i] = base;
        }
        
        for(int j = n-1; j >= n-extra; j--){
            answer[j]++;
        }
        
        return answer;
    }
}