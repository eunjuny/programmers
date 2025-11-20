import java.util.*;

class Solution {
    class Node {
        int value;
        int id;
        
        Node(int value, int id) {
            this.value = value;
            this.id = id;
        }
    }
    
    // deleted = true인 노드 제거
    private void removeValid(PriorityQueue<Node> pq, boolean[] deleted) {
        while (!pq.isEmpty() && deleted[pq.peek().id]) {
            pq.poll();
        }
    }
    
    public int[] solution(String[] operations) {
        // PriorityQueue는 낮은 값 부터 먼저 나옴. 
        // Node 객체를 넣기 때문에 우선순위를 어떻게 결정할 지 알려줘야 함.
        PriorityQueue<Node> minPQ = new PriorityQueue<>((a, b) -> a.value - b.value);   // 오름차순
        PriorityQueue<Node> maxPQ = new PriorityQueue<>((a, b) -> b.value - a.value);   // 내림차순
        
        boolean[] deleted = new boolean[operations.length]; // 삽입된 데이터 삭제 여부 기록
        int id = 0; // 삽입 데이터마다 id 부여
        
        for(String op : operations) {
            String[] parts = op.split(" ");
            String cmd = parts[0];
            int val = Integer.parseInt(parts[1]);
            
            if("I".equals(cmd)) {
                Node node = new Node(val, id);
                minPQ.offer(node);
                maxPQ.offer(node);
                id++;
            } else if ("D".equals(cmd)){
                if (val == 1) {
                    removeValid(maxPQ, deleted);
                    
                    if(!maxPQ.isEmpty()) {
                        Node n = maxPQ.poll();
                        deleted[n.id] = true;
                    }
                } else {
                    removeValid(minPQ, deleted);
                    
                    if(!minPQ.isEmpty()) {
                        Node n = minPQ.poll();
                        deleted[n.id] = true;
                    }
                }
            }
        }
        
        // 연산 끝난 후 true지만 삭제 안된 데이터 제거
        removeValid(maxPQ, deleted);
        removeValid(minPQ, deleted);
            
        // 큐가 비었으면 [0,0]
        if (minPQ.isEmpty() || maxPQ.isEmpty()) {
            return new int[]{0, 0};
        }
            
        return new int[]{maxPQ.peek().value, minPQ.peek().value};
    }
}