import java.util.HashMap;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        // 기본 요금 계산에 필요한 값
        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        
        // 입차 시간
        HashMap<String, LocalTime> mapIn = new HashMap<>();
        // 총 주차 시간
        HashMap<String, Integer> mapTotal = new HashMap<>();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        
        for (String record : records) {
            String[] rec = record.split(" ");
            String time = rec[0];
            String carNum = rec[1];
            String status = rec[2];
            
            if ("IN".equals(status)) {
                mapIn.put(carNum, LocalTime.parse(time, formatter));
            } else {
                LocalTime inTime = mapIn.remove(carNum); // 해당 값을 반환 후 삭제 (.pop()같이)
                LocalTime outTime = LocalTime.parse(time, formatter);
                
                int duration = (int) Duration.between(inTime, outTime).toMinutes();
                mapTotal.put(carNum, mapTotal.getOrDefault(carNum, 0) + duration);
            }
         }
        
        // 출차 기록이 없는 차량 처리 (mapIn에 값이 남아 있는 목록들)
        LocalTime endOfDay = LocalTime.parse("23:59", formatter);
        for (String carNum : mapIn.keySet()) {
            LocalTime inTime = mapIn.get(carNum);
            int duration = (int) Duration.between(inTime, endOfDay).toMinutes();
            mapTotal.put(carNum, mapTotal.getOrDefault(carNum, 0) + duration);
        }
        
        List<String> carNums = new ArrayList<>(mapTotal.keySet());
        Collections.sort(carNums);
        
        // 요금 계산
        int[] answer = new int[carNums.size()];
        for (int i=0; i<carNums.size(); i++) {
            String carNum = carNums.get(i);
            int totalMinutes = mapTotal.get(carNum);
            int fee = basicFee;
            
            if (totalMinutes > basicTime) {
                fee += Math.ceil((double)(totalMinutes - basicTime) / unitTime) * unitFee;
            }
            
            answer[i] = fee;
        }
        
        return answer;
    }
}