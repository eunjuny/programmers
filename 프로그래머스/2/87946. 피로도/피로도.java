class Solution {
    public static int answer = 0;
    public static boolean[] visit;
    
    public int solution(int k, int[][] dungeons) {
        visit = new boolean[dungeons.length];
        dfs(dungeons, k, 0);
        
        return answer;
    }
    
    private void dfs(int[][] dungeons, int k, int cnt) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!visit[i] && dungeons[i][0] <= k) {
                visit[i] = true;
                dfs(dungeons, k-dungeons[i][1], cnt+1);
                visit[i] = false;
            }
            answer = Math.max(cnt, answer);
        }
    }
}