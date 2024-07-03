class Solution {
    
    // 누적합을 이용한 계산
    // 전체 시간 배열을 생성한 후 각 예약의 입실 시간부터 퇴실 시간까지 배열의 값을 1씩 증가시킨다.
    // 모든 예약의 값을 배열에 입력했을 때, 전체 시간 배열 중에서 가장 큰 값이 최소로 필요한 방의 값이다.
    // ex) [0, 0, 1, 2, 2, 3, 2, 2, 1, 0, 0] 과 같을 경우, 최소로 필요한 방의 개수는 3개
    
    private static final int MAX_TIME = 1_450;  // 24*60 + 10;
    private static final int HOUR = 60;
    private static final int CLEAN_TIME = 10;
    
    public int solution(String[][] book_time) {
        
        int answer = 0;
        
        int[] rooms = new int[MAX_TIME];
        
        for (String[] time : book_time) {
            String inTime = time[0];
            String outTime = time[1];
            
            rooms[calTime(inTime)] += 1; // 입실 시간
            
            rooms[calTime(outTime) + CLEAN_TIME] += -1; // 퇴실 + 청소 시간
        }
        
        // 누적합
        for (int i = 1; i < MAX_TIME; i++) {
            rooms[i] += rooms[i-1];
            answer = Math.max(answer, rooms[i]);
        }
        
        return answer;
    }
    
    private static int calTime(String time) {
        String[] split = time.split(":");
        String hour = split[0];
        String minute = split[1];
        
        return ((Integer.parseInt(hour) * HOUR) + Integer.parseInt(minute));
    }
}
