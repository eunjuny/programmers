import java.util.*;

class Solution {
    
    static int cnt = 1;
    static int[] visited;
    static class Node {
        int x, y, v;
        
        Node(int x, int y, int v) {
            this.x = x;
            this.y = y;
            this.v = v;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        
        // 양방향 연결
        for (int[] r : road) {
            list.get(r[0]).add(new Node(r[0], r[1], r[2]));
            list.get(r[1]).add(new Node(r[1], r[0], r[2]));
        }
        visited = new int[N+1];
        for (int i = 2; i < visited.length; i++) {
            visited[i] = Integer.MAX_VALUE;
        }
        bfs(list.get(1), list, K);
        return cnt;
    }
    
    public void bfs(ArrayList<Node> node, ArrayList<ArrayList<Node>> list, int K) {
        Queue<Node> q = new LinkedList<>();
        q.addAll(node);
        
        while (!q.isEmpty()) {
            Node n = q.poll();
            if (visited[n.y] >= visited[n.x] + n.v) {
                visited[n.y] = visited[n.x] +n.v;
                q.addAll(list.get(n.y));
            }
        }
        
        for (int i = 2; i < visited.length; i++) {
            if (visited[i] <= K) cnt++;
        }
    }
    
}