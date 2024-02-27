import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        // 결과 배열 초기화
        int[] answer = new int[score.length];

        // 우선순위 큐(PriorityQueue) 선언
        // 이 우선순위 큐는 작은 값부터 오름차순으로 정렬됨
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        // 임시 변수 선언
        int temp = 0;

        // 주어진 점수 배열을 순회
        for(int i = 0; i < score.length; i++) {
            // 현재 점수를 우선순위 큐에 추가
            priorityQueue.add(score[i]);
            
            // 우선순위 큐의 크기가 k보다 크다면
            // 가장 작은 k개의 점수만 남기기 위해 가장 작은 점수를 제거함
            if (priorityQueue.size() > k) {
                priorityQueue.poll(); // 가장 작은 값 제거
            }

            // 현재 우선순위 큐에서 가장 작은 값(최하 점수)을 결과 배열에 저장
            answer[i] = priorityQueue.peek();
        }

        // 결과 배열 반환
        return answer;
    }
}
