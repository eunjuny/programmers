import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[][] bookTime = new int[book_time.length][2];
        
        for (int i = 0; i < book_time.length; i++) {
            int start = Integer.parseInt(book_time[i][0].replace(":", ""));
            int end = Integer.parseInt(book_time[i][1].replace(":",""));
            
            end += 10;  // 청소 시간
            
            if (end % 100 >= 60) {
                end += 40;  // 청소 시간을 더한 시간이 60분을 초과할 경우 1시간 증가시켜 줌
                            // ex) 퇴실이 13시 55분이면 1355 + 10 = 1365 -> 1405로 변경
            }
            
            bookTime[i][0] = start;
            bookTime[i][1] = end;
        }
        
        // 예약리스트는 입실 시간 순으로 정렬
        Arrays.sort(bookTime, (a1, a2) -> {
            return a1[0]- a2[0];
        });
            
        // 우선순위 큐는 퇴실 시간 순으로 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for (int[] book : bookTime) {
            if (pq.isEmpty()) {
                pq.add(book);   // 모든 방이 비어있으면 추가
            } else {
                int[] tmp = pq.peek();
                int start = tmp[0];
                int end = tmp[1];
                
                if (book[0] >= end) {
                    pq.poll();
                }
                pq.add(book);   // 가장 빠른 퇴실 시간보다 예약 입실 시간이 늦을 경우 퇴실 건을 삭제한 후 신규 예약 건을 추가
            }
        }
        answer = pq.size();
        return answer;
    }
}
