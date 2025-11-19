class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0; // 최소 증설 수
        int curr = 0; // 현재 사용 중인 서버 수
        
        
        int n = players.length; //24
        int[] needServer = new int[n];  // 각 시간대에 필요 증설 서버 수
        int[] addServer = new int[n];   // 각 시간대에 추가한 증설 서버 수
        
        // 증설 서버 계산
        for (int i = 0; i < n; i++) {
            needServer[i] = players[i] / m;
        }
        
        for (int t = 0; t < n; t++) {
            if(t - k >= 0) {
                curr -= addServer[t - k];   // 시간 초과 서버 종료
            }
            
            if(needServer[t] > curr) {
                int need = needServer[t] - curr;
                curr += need;
                addServer[t] += need;
                answer += need;
            }
        }
        
        return answer;
    }
}