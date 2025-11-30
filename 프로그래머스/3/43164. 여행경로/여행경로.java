import java.util.*;

class Solution {
    Map<String, PriorityQueue<String>> graph = new HashMap<>();
    List<String> route = new LinkedList<>();
    
    public String[] solution(String[][] tickets) {
        
        for (String[] t : tickets) {
            graph.putIfAbsent(t[0], new PriorityQueue<>());
            graph.get(t[0]).offer(t[1]);
        }
        
        dfs("ICN");
        
        Collections.reverse(route); // dfs 에서 while 안의 후순위 방문지부터 배열의 앞에 위치하게 됨. -> reverse 필요
        return route.toArray(new String[0]); 
        /*
            toArray에 배열을 넘겨주면:
                전달한 배열이 충분한 길이를 가지면 그 안에 요소를 채움
                길이가 부족하면 새로운 배열을 만들어 반환
            new String[0]을 넘기는 이유:
                "배열 크기 자동 생성" 용도
                사실 new String[route.size()]로 해도 되고, 최근 JDK에서는 new String[0]을 권장
                즉, 길이 0 배열을 전달하면 JDK가 리스트 크기에 맞는 새로운 배열을 생성해서 반환
        */
        
        
    }
    
    private void dfs(String airport) {
        PriorityQueue<String> pq = graph.get(airport);
        while(pq != null && !pq.isEmpty()) {
            String next = pq.poll();    // 알파벳 순으로 가장 앞선 도시
            dfs(next);
        }
        route.add(airport);
    }
}