import java.util.PriorityQueue;

class Solution {
    public long solution(long n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        String s = String.valueOf(n);
        
        for (int i = 0; i < s.length(); i++) {
            pq.offer(Integer.parseInt(s.split("")[i]));
        }
        
        StringBuilder sb = new StringBuilder();
        
        while (!pq.isEmpty()) {
            sb.append(pq.poll());    
        }
        
        long answer = Long.parseLong(sb.reverse().toString()); 
        return answer;
    }
}