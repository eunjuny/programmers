import java.util.*;

class Solution {
    
    Map<Long, Long> parent = new HashMap<>();
    
    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        
        
        for (int i = 0; i < room_number.length; i++) {
            answer[i] = find(room_number[i]);
        }
        
        return answer;
    }
    
    private long find(long room) {
        
        // 방이 비어있다면 배정
        if(!parent.containsKey(room)) {
            parent.put(room, room +1); // 다음에 해당 방이 호출 됐을 경우 해당 방 + 1번 방 출력 
            return room;    // 해당 방 배정
        }
        
        // 방이 이미 배정 됐으면 다음 방 찾음
        long next = find(parent.get(room));
        
        // 다음에 호출 됐을 때 대비해서 방 번호 올려 놓기
        parent.put(room, next+1);
        
        return next;
        
    }   
}