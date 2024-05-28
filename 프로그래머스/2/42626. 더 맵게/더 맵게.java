import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> q =  new PriorityQueue<Integer>();   // 우선순위 큐는 최소힙으로 만들어진다.
        
        for (int i = 0; i < scoville.length; i++) {
            q .add(scoville[i]);
        }
        
        while(q.peek() < K) {
            if (q.size() < 2) {
                return -1;
            } else {
                q.offer(q.poll() + (q.poll() * 2));
                answer++;
            }
        }
        
        return answer;
    }
}