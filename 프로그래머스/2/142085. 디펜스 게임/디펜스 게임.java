import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < enemy.length; ++i){
            maxHeap.add(enemy[i]); // 현재 진행하면서 제일 큰 숫자 
            n -= enemy[i];
            if(n < 0 && k > 0){ // 무적권 사용
                n += maxHeap.poll();
                k--;
                answer = i;
            }
            if(n < 0 && k <= 0) { // 더 이상 진행 불가
                answer = i-1;
                break;
            }
            if(n >= 0) { // 여기 까지는 진행 완료
                answer = i;
            }
        }
        return answer+1;
    }
}