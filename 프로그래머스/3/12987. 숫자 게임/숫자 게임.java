import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        PriorityQueue<Integer> apq = new PriorityQueue();
        PriorityQueue<Integer> bpq = new PriorityQueue();
        
        for(int i = 0; i < A.length; i++) {
            apq.add(A[i]);
            bpq.add(B[i]);
        }
        
        while(!apq.isEmpty()) {
            int a = apq.poll();
            while(!bpq.isEmpty()) {
                int b = bpq.poll();
                if(b > a) {
                    answer++;
                    break;
                }
            }
        }
        
        
        return answer;
    }
}