import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        } 
        for(int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offerLast(destination);
        
        int[] distance = new int[n+1];
        Arrays.fill(distance, -1);
        distance[destination] = 0;
        
        while(!dq.isEmpty()) {
            int curr = dq.pollFirst();
            for(int next : graph.get(curr)) {
                if(distance[next] == -1) {
                    distance[next] = distance[curr] + 1;
                    dq.offerLast(next);
                }
            }
        }
        
        int[] answer = new int[sources.length];
        for(int i = 0; i < sources.length; i++) {
            answer[i] = distance[sources[i]];
        }
        
        return answer;
    }
}