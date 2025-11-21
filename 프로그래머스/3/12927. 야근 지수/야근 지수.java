import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    
        
        int l = 0;
        int sum = 0;
        while(l < works.length) {
            pq.add(works[l]);
            sum += works[l];
            l++;
        }
        
        if(sum <= n) {
            return 0;
        }
        
        while(n > 0) {
            int q = pq.poll();
            if (q == 0) {
                break;
            }
            pq.add(q-1);
            n--;
        }
        
        while(!pq.isEmpty()) {
            int a = pq.poll();
            answer += (a * a);
        } 
    
        
        return answer;
    }
}