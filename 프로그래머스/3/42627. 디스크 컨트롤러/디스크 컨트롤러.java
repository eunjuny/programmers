import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a,b) -> a[0] - b[0]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);    
    
        int t = 0;
        int totalTime = 0;
        int jobNum = 0;
        
        while(jobNum < jobs.length || !pq.isEmpty()) {
            while(jobNum < jobs.length && jobs[jobNum][0] <= t) {
                pq.add(jobs[jobNum++]);
            }
            
            if(pq.isEmpty()) {
                t=jobs[jobNum][0];
                continue;
            } else {
                int[] job = pq.poll();
                t += job[1];
                totalTime += (t - job[0]);
            }
        }
        
        return totalTime / jobs.length;
    }
}