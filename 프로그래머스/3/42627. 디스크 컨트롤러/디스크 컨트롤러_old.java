import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        
        // 배열을 시작 시간을 기준으로 오름차순 정렬
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        // 처리 시간 기준으로 오름차순 정렬해서 우선 순위 큐에 저장
        PriorityQueue<int[]> que = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        int idx = 0;	// 수행 중인 job
        int cnt = 0;	// 수행 요청 수
        int totalTime = 0;	// 총 수행 시간
        int end = 0;	// 수행 직후 시간
        
        while(cnt < jobs.length){
            // 작업 중에 들어온 요청들을 큐에 넣음
            while(idx < jobs.length && jobs[idx][0] <= end) {
                que.add(jobs[idx++]);
            }
            
            // 큐가 비어 있을 경우 다음 요청의 시작 시간으로 이동
            if(que.isEmpty()){
                end = jobs[idx][0];
            } else {
                // 큐에 있는 작업 중 수행 시간이 짧은 요청부터 수행
                int[] work = que.poll();
                totalTime += work[1] + end - work[0];
                end += work[1];
                cnt++;
            }
           
        }
       
        return totalTime/jobs.length;
    }
}
