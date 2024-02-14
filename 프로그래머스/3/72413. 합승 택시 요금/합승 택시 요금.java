import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

  private int[][] graph;	// 그래프를 나타내는 인접 행렬
  private static final int INF = 300 * 1000000;		// 무한대를 나타내는 상수
    
  public int solution(int n, int s, int a, int b, int[][] fares) {
      int answer = Integer.MAX_VALUE;	// 최종 결과값을 저장할 변수
      
      //	그래프 초기화: 모든 간선의 가중치를 무한대로 초기화
      graph = new int[n][n];
      for(int i=0; i<n; i++){
          Arrays.fill(graph[i], INF);
      }
      
      // 주어진 fares 배열을 이용하여 그래프의 간선 가중치를 설정
      for(int[] fare : fares){
          graph[fare[0]-1][fare[1]-1] = graph[fare[1]-1][fare[0]-1] =fare[2];
      }
      
      int[] shortestFeeFromS = dijkstra(s-1);
      int[] shortestFeeFromA = dijkstra(a-1);
      int[] shortestFeeFromB = dijkstra(b-1);
      
      // 최단 경로를 이용하여 최소 합계 비용 계싼
      for(int i=0; i<n; i++){
          answer = Math.min(answer, shortestFeeFromS[i] + shortestFeeFromA[i] + shortestFeeFromB[i]);
      }
      
      return answer;
  }
    
    private int[] dijkstra(int target){
        int[] result = new int[graph.length];	// 최단 거리를 저장할 배열
        Arrays.fill(result, INF);	// 초기에는 모든 정점까지의 거리를 무한대로 설정
        result[target] = 0;	// 출발 정점의 거리는 0  ex) a->a = 0
        
        // 우선순위 큐를 이용한 다익스트라 알고리즘 수행
        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(target, 0));
        
        while(!queue.isEmpty()){
            Node node = queue.poll();	// 우선순위 큐에서 가장 가까운 정점을 뽑아냄
            if(result[node.index]<node.cost){	// 현재 정점까지의 거리가 이미 더 짧은 경우 건너뜀
                continue;
            }
            
            // 현재 정점을 통해 갈 수 있는 다른 정점들에 대한 처리
            for (int i=0; i<graph.length; i++){
                if(result[i] > node.cost + graph[node.index][i]){
                    result[i] = node.cost + graph[node.index][i];	// 더 짧은 거리로 업데이트
                    queue.add(new Node(i, node.cost + graph[node.index][i]));	// 큐에 추가
                }
            }
        }
        return result;
    }
    
    // 다익스트라 알고리즘에서 사용되는 정점 클래스
    class Node implements Comparable<Node> {
        int index;	// 정점 번호
        int cost;	// 출발 정점으로부터의 거리
        
        public Node(int index, int cost){
            this.index = index;
            this.cost = cost;
        }
        
        // 우선순위 큐에서 비교를 위한 compareTo 메서드 오버라이딩
        @Override
        public int compareTo(Node o){
            return this.cost - o.cost;	// 거리 기준 정렬
        }
    }
}


