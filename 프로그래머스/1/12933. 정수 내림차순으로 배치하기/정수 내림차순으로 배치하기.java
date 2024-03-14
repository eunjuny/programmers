import java.util.PriorityQueue;

class Solution {
    public long solution(long n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        String s = String.valueOf(n);
        
        for (int i = 0; i < s.length(); i++) {
            pq.offer(Integer.parseInt(s.split("")[i]));
        }
        
        int idx = 0;
        // StringBuilder sb = new StringBuilder();
        String st = "";
        
        while (!pq.isEmpty()) {
            // sb.append(pq.poll());    
            st = pq.poll() + st;
        }
        
        long answer = Long.parseLong(st); 
        return answer;
    }
}